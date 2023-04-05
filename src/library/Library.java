/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import library.controller.BookController;
import library.model.Book;

/**
 *
 * @author Silvia Shimabuko
 */
public class Library {

    private List<Book> books;
    
    public Library(){
        this.books = new ArrayList<>();
        
        BookController bookController = new BookController();
        this.books = bookController.loadDataBooks();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println(Arrays.toString(library.books.toArray()));
        
    }
    
}
