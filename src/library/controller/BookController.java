/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.controller;

import java.util.List;
import library.model.Book;
import library.model.dao.BookDAO;

/**
 *
 * @author Silvia Shimabuko
 */
public class BookController {
    private BookDAO dao = new BookDAO();
    
    public void loadDataBooks() {
        dao.loadDataBooks();
    }
    
    public String listBooksAsString(List<Book> books,String orderDescriptionBy) {
        return dao.listBooksAsString(books, orderDescriptionBy);
    }
    
    public void mergeSort(String orderBy) {
        dao.mergeSort(orderBy);
    }

    public int binarySearch(String targetName, String field) {
        return dao.binarySearch(targetName, field);
    }
    
    public List<Book> getBooks() {
        return dao.getBooks();
    }
    public List<Book> findBookContains(String target) {
        return dao.findBookContains(target); 
    }
}