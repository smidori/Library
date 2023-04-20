/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.controller;

import java.util.List;
import library.model.Book;
import library.model.LendBook;
import library.model.Student;
import library.model.dao.LendBookDAO;

/**
 *
 * @author Silvia Shimabuko
 */
public class LendBookController {

    private final LendBookDAO dao = new LendBookDAO();

    public List<LendBook> getLendBooks() {
        return dao.getLendBooks();
    }

    public void loadDataLendBooks() {
        dao.loadDataLendBooks();
    }

    public int searchLastRegisterByIdBook(String idBook, boolean isLent) {
        return dao.searchLastRegisterByIdBook(idBook, isLent);
    }

    public List<LendBook> searchLendBookByStudent(int idStudent) {
        return dao.searchLendBookByStudent(idStudent);
    }

    public void add(Book book, Student student) {
        dao.add(book, student);
    }
    
    public void save() {
        dao.save();
    }

}
