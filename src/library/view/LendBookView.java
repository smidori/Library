/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.view;

import java.time.LocalDateTime;
import java.util.List;
import library.controller.LendBookController;
import library.model.Book;
import library.model.LendBook;
import library.model.Student;
import library.utilities.ColorMessage;

/**
 *
 * @author Silvia Shimabuko
 */
public class LendBookView {

    private static LendBookController lbc = new LendBookController();

    public void addLendBook(Book book, Student student) {
        lbc.add(book, student);
        lbc.save();
        ColorMessage.print("Operation completed successfully", ColorMessage.GREEN);
    }
    
    public void returnBook(String idBook) {        
        int indexLendBook = lbc.searchLastRegisterByIdBook(idBook, true);
        
        if (indexLendBook < 0) {
            Menu.printItemNotFound("book", idBook);
        } else {
            LendBook lb = lbc.getLendBooks().get(indexLendBook);
            lb.setReturnDate(LocalDateTime.now());
            
            System.out.println("Book returned with success!!!");
        }
    }
    
    public void listLendBooksByStudent(Student student) {
        List<LendBook> lendBooksStudent = lbc.searchLendBookByStudent(student.getId());
        if (lendBooksStudent.isEmpty()) {
            ColorMessage.print("\nNo one book was lent to this student: " + student.getId(), ColorMessage.PINK);
        } else {
            ColorMessage.print("\nBellow are list the books were lent to the student: " + student.getId()
                    + " - " + student.getFullName(), null);
            for (LendBook lb : lendBooksStudent) {
                System.out.println(lb.borrowedBookDetail());
            }
        }
    }
}
