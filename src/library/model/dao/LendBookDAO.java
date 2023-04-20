/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import library.model.Book;
import library.model.LendBook;
import library.model.Student;
import library.utilities.DateUtils;
import library.utilities.ReadCSV;
import library.utilities.WriteCSV;

/**
 *
 * @author Silvia Shimabuko
 */
public class LendBookDAO {
    public static final String FILE_LEND_BOOK = "LEND_BOOK_DATA.csv";
    private static List<LendBook> lendBooks;
    
    
    public List<LendBook> getLendBooks() {
        return lendBooks;
    }
    
    /**
     * Load the csv file data into java
     */
    public void loadDataLendBooks() {
        lendBooks = new ArrayList<>();
        
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_LEND_BOOK);

        if (lines != null) {
            for (String line : lines) {
                String[] data = line.split(",", -1);
                LendBook lendBook = new LendBook(data[0], data[1], Integer.parseInt(data[2]), DateUtils.stringToDate(data[3]), DateUtils.stringToDate(data[4]));
                lendBooks.add(lendBook);
            }
        }
    }
    
    public int searchLastRegisterByIdBook(String idBook, boolean isLent) {
        for (int i = lendBooks.size() - 1; i >= 0; i--) {//TODO SEARCH FROM MOST RECENT TO THE OLD
            LendBook lendBook = lendBooks.get(i);
            if (isLent) {//it will return the book in case the book is lent already, it means with return date null
                if (lendBook.getIdBook().equalsIgnoreCase(idBook) && lendBook.getReturnDate() == null) {
                    return i;
                }
            } else {
                if (lendBook.getIdBook().equalsIgnoreCase(idBook) && lendBook.getReturnDate() != null) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public void add(Book book, Student student) {
        LocalDateTime now = LocalDateTime.now();
        LendBook lb = new LendBook(DateUtils.dateToString(now), book.getId(), student.getId(), now, null);
        lendBooks.add(lb);
    }

    public void save() {
        List<String> data = new ArrayList<>();
        data.add(LendBook.HEAD_CSV);
        for (int i = 0; i < lendBooks.size(); i++) {
            data.add(lendBooks.get(i).getCSVFormat());
        }
        WriteCSV.writefile(LendBookDAO.FILE_LEND_BOOK, data);
    }
    
    public List<LendBook> searchLendBookByStudent(int idStudent) {
        List<LendBook> lendBooksByStudent = new ArrayList<>();

        for (int i = 0; i < lendBooks.size(); i++) {
            if (lendBooks.get(i).getIdStudent() == idStudent) {
                lendBooksByStudent.add(lendBooks.get(i));
            }
        }
        return lendBooksByStudent;
    }
    
    
}
