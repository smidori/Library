/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.view;

import java.util.List;
import library.controller.BookController;
import library.model.Book;
import library.utilities.ColorMessage;
import library.utilities.InputUtils;

/**
 *
 * @author Silvia Shimabuko
 */
public class BookView {

    private BookController bc = new BookController();
    
    public Book searchBookbyId() {
        String searchBookId = InputUtils.getUserText("Type the book id", ColorMessage.BLUE);
        Menu.printSearching("book");
        int indexBook = bc.binarySearch(searchBookId, "id");
        if (indexBook < 0) {
            Menu.printItemNotFound("book", searchBookId);
            return null;
        }else{
            return bc.getBooks().get(indexBook);
        }
    }
    
    public void searchBook(String field) {
        String search ="";
        boolean invalidSearch;
        do{
            invalidSearch=false;
            search = InputUtils.getUserText("Enter the " + field, ColorMessage.BLUE);
            //check if it's a full name
            if(field.equalsIgnoreCase("author")){
                if(!search.trim().contains(" ")){
                    ColorMessage.print("Please, type first and last name", ColorMessage.PINK);
                    invalidSearch = true;
                }
            }
        }while(invalidSearch);
        
        Menu.printSearching(field);
        
        int indexBook = bc.binarySearch(search, field);
        
        if (indexBook < 0) {
            Menu.printItemNotFound("book", search);
        } else {
            System.out.println("BOOK \n" + bc.getBooks().get(indexBook).toString() + "\n");
        }
    }

    public void listBooks(String field) {
        List<Book> books = bc.bubbleSorted(field);
        System.out.println("BOOKS LIST\n" + bc.listBooksAsString(books, field));
    }

}
