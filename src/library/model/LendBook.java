/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model;

import java.time.LocalDateTime;
import library.utilities.DateUtils;

/**
 *
 * @author Silvia Shimabuko
 */
public class LendBook {
    public static final String HEAD_CSV = "Id,idBook,idStudent,borrowingDate,returnDate\n";
    
    private String id;
    private String idBook;
    private int idStudent;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
    

    public LendBook(String id, String idBook, int idStudent, LocalDateTime borrowDate, LocalDateTime returnDate) {
        this.id = id;
        this.idBook = idBook;
        this.idStudent = idStudent;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
    
    public String getCSVFormat(){
        StringBuilder sb = new StringBuilder();
        sb.append(id+","+idBook+","+idStudent + ",");
        sb.append(DateUtils.dateToString(borrowDate)+",");
        sb.append(DateUtils.dateToString(returnDate));
        sb.append("\n");
        return sb.toString();
    }
    
    public String borrowedBookDetail(){
        return "\nid Book: " + idBook + "\nBorrow date " + DateUtils.dateToStringDateHour(borrowDate) + 
                "\nReturn date " + DateUtils.dateToStringDateHour(returnDate);
    }
    
    
}
