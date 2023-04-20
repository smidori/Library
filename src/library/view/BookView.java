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
    
    /**
     * Search the book based the field in the menu option selected
     * @param field 
     */
    public void searchBook(String field) {
        String search ="";
        boolean invalidSearch;//used to control if was typed a full name
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
    /**
     * List books with the fields in different position depends on the field parameter
     * @param field 
     */
    public void listBooks(String field) {
        bc.mergeSort(field);
        if (field.equalsIgnoreCase("author")) {
            ColorMessage.print("\t\t\tId\t\t-\tAuthor\t-\tTitle\n", ColorMessage.BOLD_GRAY);
        } else {
            ColorMessage.print("\t\t\tId\t\t-\tTitle\t-\tAuthor\n", ColorMessage.BOLD_GRAY);
        }
        System.out.println(bc.listBooksAsString(bc.getBooks(), field));
    }
    
    public void listBooks(List<Book> books, String field) {
        if (field.equalsIgnoreCase("author")) {
            ColorMessage.print("Id\t-\tAuthor\t-\tTitle\n", ColorMessage.BOLD_GRAY);
        } else {
            ColorMessage.print("Id\t-\tTitle\t-\tAuthor\n", ColorMessage.BOLD_GRAY);
        }
        System.out.println(bc.listBooksAsString(books, field));
    }
    
    /**
     * Search the book that contains the word in id, title and/or author
     */
    public void searchBookByAnyWord() {
        //search book by the text
        String search = InputUtils.getUserText("Type the word for search in id, title and/or author", ColorMessage.BLUE);
        List<Book> books = bc.findBookContains(search);
        if (books.isEmpty()) {
            ColorMessage.print("This word [" + search + "] wasn't find in any book", ColorMessage.PINK);
        } else {
            listBooks(books, "title");
        }
    }

}
