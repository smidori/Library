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
        int qttMenuItens = 15; //necessary to control until which number the user can type
        selectedMenu = InputUtils.getUserIntBetween(currentMenu, 0, qttMenuItens, ColorMessage.BLUE);

        while (selectedMenu != 0) {//ask to type a number until the user type 0 in the main menu

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
                case 6: {//Search the book that contains the word in id, title and/or author, 
                    //the accents in this type of search matters
                    bv.searchBookByAnyWord();
                    break;
                }
                case 7: {//list student ordered by name
                    String field = "name";
                    sc.mergeSort(field);
                    sv.listStudents(sc.getStudents(), field);
                    break;
                }
                case 8: {//list student ordered by id
                    String field = "id";
                    sc.mergeSort(field);
                    sv.listStudents(sc.getStudents(), field);
                    break;
                }
                case 9: {//search the student by name
                    sv.search("name");
                    break;
                }
                case 10: {//search the student by id
                    sv.search("id");
                    break;
                }
                case 11: { //lend book
                    Book book = bv.searchBookbyId();
                    if (book != null) {
                        Student student = sv.searchStudentById();
                        if (student != null) {
                            //check if this book is already lent to someone
                            int indexLendBook = lbc.searchLastRegisterByIdBook(book.getId(), true);
                            if (indexLendBook >= 0) {//book already lent
                                if (lbc.getLendBooks().get(indexLendBook).getIdStudent() == student.getId()) {
                                    ColorMessage.print("This book is already lent to this student", ColorMessage.PINK);
                                } else {
                                    ColorMessage.print("This book is already lent to another student", ColorMessage.PINK);
                                    
                                    //might add the student to waiting list
                                    wlv.addWaitingList(book, student); 
                                }
                            } else {//Add lend Book - book is available
                                //check if there is someone in the waiting list before lent it
                                Queue students = wlc.getWaitingList().get(book.getId());
                                if (students == null) {//there is no one in the waiting list
                                    lbv.addLendBook(book, student); //lent to the student
                                } else { //there is someone in the waiting list
                                    String firstInQueue = students.First();
                                    if (firstInQueue.equalsIgnoreCase(String.valueOf(student.getId()))) {//should be the first to get this book
                                        lbv.addLendBook(book, student);
                                        //remove this student from the queue;
                                        wlc.removeFirstStudent(book.getId());
                                        wlc.save();
                                    } else {//if isn't the first in the list, do not allow to lent
                                        ColorMessage.print("Sorry, the book is available but there is an waiting list for this book", ColorMessage.PINK);
                                        wlv.addWaitingList(book, student);
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
                case 12: { //return the book
                    Book book = bv.searchBookbyId();
                    if (book != null) {
                        //return the book
                        lbv.returnBook(book.getId());
                        lbc.save();
                        
                        //check if there is any student in the waiting list for this book and show to the user
                        List<Student> students = wlc.findStudentsWaitingListbyIdBook(book.getId());
                        if (!students.isEmpty()) {
                            String message = "There is a waiting list for this book (" + book.getId() + "), with " + students.size() + " student(s)";
                            ColorMessage.print(message, ColorMessage.YELLOW);
                        }
                    }
                    break;
                }
                case 13: {//list books lent to the student
                    Student student = sv.searchStudentById();
                    if (student != null) {
                        lbv.listLendBooksByStudent(student);
                    }
                    break;
                }
                case 14: {// search waiting list by book id
                    String searchIdBook = InputUtils.getUserText("Type the book id", ColorMessage.BLUE);
                    Menu.printSearching("waitling list");
                    List<Student> students = wlc.findStudentsWaitingListbyIdBook(searchIdBook);
                    if (students.isEmpty()) {
                        ColorMessage.print("\nWaiting list for the book [" + searchIdBook + "] not found :( \n", ColorMessage.PINK);
                    } else {
                        ColorMessage.print("\nSTUDENTS WAITING LIST\n", ColorMessage.LIGHT_GRAY);
                        sv.listStudents(students, "id");
                    }
                    break;
                }
                case 15: {//remove 1° student from queue
                    String searchIdBook = InputUtils.getUserText("Type the book id", ColorMessage.BLUE);
                    Menu.printSearching("waitling list");

                    //int indexWL = wlc.linearSearch(wlc.getWaitingList(), searchIdBook);
                    Queue students = wlc.getWaitingList().get(searchIdBook);
                    if (students == null) {//there is no one in the waiting list
                        ColorMessage.print("There is no waiting list for this book", ColorMessage.PINK);
                    } else {
                        wlc.removeFirstStudent(searchIdBook);
                        wlc.save();
                        ColorMessage.print("1° Student removed from the waiting list with success", ColorMessage.GREEN);
                    }

                }
            }
            if (InputUtils.getUserPressEnter()) {
                selectedMenu = InputUtils.getUserIntBetween(currentMenu, 0, qttMenuItens, ColorMessage.BLUE);
            }
        }
        ColorMessage.print("Program is finalized!!!", ColorMessage.GREEN);
    }

}
