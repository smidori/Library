/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import library.controller.BookController;
import library.controller.LendBookController;
import library.controller.StudentController;
import library.controller.WaitingListController;
import library.model.Book;
import library.model.LendBook;
import library.model.Student;
import library.model.WaitingList;
import library.utilities.DateUtils;
import library.utilities.InputUtils;
import library.utilities.Queue;
import library.utilities.WriteCSV;
import library.view.Menu;

/**
 *
 * @author Silvia Shimabuko
 */
public class Library {

    private List<Book> books;
    private List<Student> students;
    private List<LendBook> lendBooks;
    private List<WaitingList> waitingList;

    private static final BookController bc = new BookController();
    private static final StudentController sc = new StudentController();
    private static final LendBookController lbc = new LendBookController();
    private static final WaitingListController wlc = new WaitingListController();

    public Library() {
        this.books = new ArrayList<>();
        this.books = bc.loadDataBooks();
        this.students = sc.loadDataStudents();
        this.lendBooks = lbc.loadDataLendBooks();
        this.waitingList = wlc.loadDataWaitingList();
        System.out.println(waitingList.size());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Library library = new Library();
        Menu menu = new Menu();

        //System.out.println(Arrays.toString(library.books.toArray()));
        int selectedMenu;

        String currentMenu = menu.mainMenu();
        selectedMenu = InputUtils.getUserInt(currentMenu, 0, 10);

        while (selectedMenu != 0) {//ask to type a number until the user type 0 in the main menu
            String msg;

            switch (selectedMenu) {

                case 1 -> //list all books ordered by title
                    System.out.println("BOOKS LIST\n" + bc.listBooksAsString(bc.bubbleSorted(library.books, "title"), "title"));
                case 2 ->  //list all books ordered by author
                    System.out.println("BOOKS LIST\n" + bc.listBooksAsString(bc.bubbleSorted(library.books, "author"), "author"));
                case 3 -> { //search book by title
                    String searchTitle = InputUtils.getUserText("Type the title of the book");
                    //linear search get just the first element found, in this case, the second book will never be found
                    System.out.println("\n Searching for the book....\n");

                    int indexBook = bc.linearSearch(library.books, searchTitle, "title");
                    if (indexBook < 0) {
                        System.out.println("Sorry, book [" + searchTitle + "] not found :( \n");
                    } else {
                        //World War Z
                        //You're Not You
                        //More About the Children of Noisy Village (a.k.a. More About the Children of Bullerby Village) (Mer om oss barn i Bullerbyn)
                        //Marley & Me
                        //Kevin Smith: Too Fat For 40
                        //Hidden (a.k.a. Cache) (Caché)
                        //Hellraiser: Deader
                        //Goal! The Dream Begins (Goal!)
                        //Zatoichi's Vengeance (Zatôichi no uta ga kikoeru) (Zatôichi 13)
                        System.out.println("BOOK \n" + library.books.get(indexBook).toString() + "\n");
                    }
                }
                case 4 -> { //search book by author
                    String searchAuthor = InputUtils.getUserText("Type the name of author");
                    //linear search get just the first element found, in this case, the second book will never be found
                    System.out.println("\n Searching for the author....\n");
                    int indexBook = bc.linearSearch(library.books, searchAuthor, "author");
                    if (indexBook < 0) {
                        System.out.println("Sorry, author [" + searchAuthor + "] not found :( \n");
                    } else {
                        //World War Z
                        System.out.println("Author \n" + library.books.get(indexBook).toString() + "\n");
                    }
                    //Whitman Maw
                }
                case 8 -> {
                    String searchTitle = InputUtils.getUserText("Type the title of the book that would be lend ");
                    //linear search get just the first element found, in this case, the second book will never be found
                    System.out.println("\n Searching for the book....\n");

                    int indexBook = bc.linearSearch(library.books, searchTitle, "title");
                    if (indexBook < 0) {
                        System.out.println("Sorry, book [" + searchTitle + "] not found :( \n");
                    } else {
                        Book book = library.books.get(indexBook);

                        //TODO buscar o estudante
                        int indexStudent = InputUtils.getUserInt("DIGITE O ID DO STUDENT - TEMPORARIO", 0, 5);

                        Student student = library.students.get(indexStudent);
                        String confirmMessage = "Would you like to lend the book: " + book.getTitle()
                                + " to the student: " + student.getFirstName() + "? \n"
                                + " Type 1 to confirm or 2 to cancel the operation";//TODO full name
                        int confirm = InputUtils.getUserInt(confirmMessage, 1, 2);
                        if (confirm == 1) {
                            //CASO O LIVRO NÃO ESTÁ DISPONÍVEL, COLOCAR NA LISTA DE ESPERA
                            //Check if the book is available
                            if (lbc.linearSearch(library.lendBooks, book.getId()) >= 0) {
                                System.out.println("This book is already lent, you were added to the waiting list");
                                //book is already lent, then need to add the name to the waiting list
                                int indexWL = wlc.linearSearch(library.waitingList, book.getId());
                                if (indexWL >= 0) {
                                    //add to the current waiting list
                                    library.waitingList.get(indexWL).getStudents().Enqueue(student.getId() + "");
                                } else {
                                    //add new register to the waiting list
                                    Queue studentsIdWL = new Queue();
                                    studentsIdWL.Enqueue(student.getId() + "");
                                    WaitingList newWaitingList = new WaitingList(book.getId(), studentsIdWL);
                                    library.waitingList.add(newWaitingList);
                                }
                                //TODO update csv waiting list
                                List<String> datas = new ArrayList<>();
                                //WaitingList wlStr = new LendBook(DateUtils.dateToString(now), book.getId(), student.getId(), now, null);
                                datas.add(WaitingList.HEAD_CSV);
                                for (int i = 0; i < library.waitingList.size(); i++) {
                                    datas.add(library.waitingList.get(i).getCSVFormat());
                                }

                                WriteCSV.writefile(WaitingListController.FILE_WAITING_LIST, datas);
                                System.out.println("Operation completed successfully");
                            } else {

                                book.setIsAvailable(false);
                                List<String> datas = new ArrayList<>();
                                LocalDateTime now = LocalDateTime.now();
                                LendBook lb = new LendBook(DateUtils.dateToString(now), book.getId(), student.getId(), now, null);
                                datas.add(LendBook.HEAD_CSV);
                                datas.add(lb.getCSVFormat());
                                WriteCSV.writefile(LendBookController.FILE_LEND, datas);
                                library.lendBooks.add(lb);
                                System.out.println("Operation completed successfully");
                            }

                        } else {
                            System.out.println("Operation cancelled");
                        }
                        //Marley & Me
                    }
                }
            }
            //selectedMenu = InputUtils.getUserInt(currentMenu, 0, 10);
            if (InputUtils.getUserPressEnter()) {
                selectedMenu = InputUtils.getUserInt(currentMenu, 0, 10);
            }

        }

    }

}
