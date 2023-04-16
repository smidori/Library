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

    public List<Book> bubbleSorted(List<Book> books, String orderBy) {
        return dao.bubbleSorted(books, orderBy);
    }

    //TODO
    /**
     * Visit every position in the array, until find the element that matches with the criteria
     * @param targetName
     * @param field
     * @return 
     */
    public int linearSearch(String targetName, String field) {
        return dao.linearSearch(targetName, field);
    }
    
    public List<Book> getBooks() {
        return dao.getBooks();
    }
}