/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.utilities;

import java.util.ArrayList;
import java.util.List;
import library.model.Book;

/**
 *
 * @author Silvia Shimabuko
 */
public class LoadFile {
    
    public static final String FILE_BOOK = "MOCK_DATA.csv";
    
    public List<Book> loadBook(){
        List<Book> books = new ArrayList<>();
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_BOOK);
        
        if(lines != null){
            for(String line: lines){
                String data[] = line.split(",");
                
                Book book = new Book(data[0],data[1],data[2], data[3],data[4]);
                books.add(book);
            }
        }
        
        return books;
    }
    
}
