/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.controller;

import java.util.ArrayList;
import java.util.List;
import library.model.Book;
import library.utilities.ReadCSV;

/**
 *
 * @author Silvia Shimabuko
 */
public class BookController {
    
    public static final String FILE_BOOK = "BOOKS_DATA.csv";
    
    public List<Book> loadDataBooks(){
        List<Book> books = new ArrayList<>();
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_BOOK);
        
        if(lines != null){
            for(String line: lines){
                //this pattern is to ignore to slit by comma when it is inside of quotes
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                
                Book book = new Book(data[0],data[1],data[2], data[3],data[4]);
                books.add(book);
            }
        }
        
        return books;
    }
}
