/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library;

import java.util.List;
import library.controller.BookController;
import library.controller.LendBookController;
import library.controller.StudentController;
import library.controller.WaitingListController;
import library.model.Book;
import library.model.Student;
import library.utilities.ColorMessage;
import library.utilities.InputUtils;
import library.utilities.Queue;
import library.view.BookView;
import library.view.LendBookView;
import library.view.Menu;
import library.view.StudentView;
import library.view.WaitingListView;

/**
 *
 * @author Silvia Shimabuko
 */
public class Library {

    //CONTROLLERS
    private static final BookController bc = new BookController();
    private static final StudentController sc = new StudentController();
    private static final LendBookController lbc = new LendBookController();
    private static final WaitingListController wlc = new WaitingListController();

    //VIEWS
    private static final BookView bv = new BookView();
    private static final StudentView sv = new StudentView();
    private static final WaitingListView wlv = new WaitingListView();
    private static final LendBookView lbv = new LendBookView();

    public Library() {
        bc.loadDataBooks();
        sc.loadDataStudents();
        lbc.loadDataLendBooks();
        wlc.loadDataWaitingList();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Library library = new Library();
        Menu menu = new Menu();

        //System.out.println(Arrays.toString(bc.getBooks().toArray()));
        int selectedMenu;

        String currentMenu = menu.mainMenu();
        int qttMenuItens = 12;
        selectedMenu = InputUtils.getUserIntBetween(currentMenu, 0, qttMenuItens, ColorMessage.BLUE);

        while (selectedMenu != 0) {//ask to type a number until the user type 0 in the main menu
            String msg;

            switch (selectedMenu) {
                case 1: //list all books ordered by title
                    bv.listBooks("title");
                    break;
                case 2:  //list all books ordered by author
                    bv.listBooks("author");
                    break;
                case 3: { //search book by title
                    bv.searchBook("title");
                    break;
                }
                case 4: { //search book by author
                    bv.searchBook("author");
                    break;
                }
                case 5: { //search book by id
                    bv.searchBook("id");
                    break;
                }
                case 6: {//list student ordered by name
                    sv.listStudents("name");
                    break;
                }
                case 7: {//list student ordered by id
                    sv.listStudents("id");
                    break;
                }
                case 8: {//search the student by name
                    sv.search("name");
                    break;
                }
                case 9: {//search the student by id
                    sv.search("id");
                    break;
                }
                case 10: {
                    Book book = bv.searchBookbyId();
                    if (book != null) {
                        Student student = sv.searchStudentById();
                        if (student != null) {
                            int indexLendBook = lbc.searchLastRegisterByIdBook(book.getId(), true);
                            if (indexLendBook >= 0) {//add to the waiting list
                                if (lbc.getLendBooks().get(indexLendBook).getIdStudent() == student.getId()) {
                                    ColorMessage.print("This book is already lent to this student", ColorMessage.PINK);
                                } else {
                                    ColorMessage.print("This book is already lent to another student", ColorMessage.PINK);
                                    wlv.addWaitingList(book, student);
                                }
                            } else {//Add lend Book
                                //check if there is someone in the waiting list
                                int indexWL = wlc.linearSearch(wlc.getWaitingList(), book.getId());
                                
                                if(indexWL < 0){//there is no one in the waiting list
                                    lbv.addLendBook(book, student);
                                }else{
                                    Queue students = wlc.getWaitingList().get(indexWL).getStudents();
                                    String firstInQueue = students.First();
                                    if(firstInQueue.equalsIgnoreCase(String.valueOf(student.getId()))){//should be the first to get this book
                                        lbv.addLendBook(book, student);
                                        //remove this student from the queue;
                                        wlc.removeFirstStudent(book.getId());
                                        wlc.save();
                                    }else{
                                        ColorMessage.print("Sorry, the book is available but there is an waiting list for this book", ColorMessage.PINK);
                                        wlv.addWaitingList(book, student);
                                    }
                                }
                                //ff2dea5d-1406-48c7-9143-fe5a4c1a9123
                            }
                        }
                    }
                    break;
                }
                case 11: {//list books lent to the student
                    Student student = sv.searchStudentById();
                    if(student != null) {
                        lbv.listLendBooksByStudent(student);
                    }
                    break;
                }
                case 12: {
                    Book book = bv.searchBookbyId();
                    if (book != null) {
                        lbv.returnBook(book.getId());
                    }                    
                    lbc.save();
                    break;
                }
                case 13: {//show search waiting list by book id
                    //578eb3bd-9458-44c8-bcd5-6edb6c48a6f2
                    String searchIdBook = InputUtils.getUserText("Type the book id", ColorMessage.BLUE);
                    Menu.printSearching("waitling list");
                    List<Student> students = wlc.findStudentsWaitingListbyIdBook(searchIdBook);
                    if (students.isEmpty()) {
                        System.out.println("Waiting list for the book [" + searchIdBook + "] not found :( \n");
                    } else {
                        System.out.println("STUDENTS WAITING LIST\n" + sc.listStudentsAsString(students, "id"));
                    }
                    break;
                }
            }
            if (InputUtils.getUserPressEnter()) {
                selectedMenu = InputUtils.getUserIntBetween(currentMenu, 0, qttMenuItens, ColorMessage.BLUE);
            }
        }
        ColorMessage.print("Program is finalized!!!", ColorMessage.BLUE);
    }

}