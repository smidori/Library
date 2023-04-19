/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.comparator;

import java.util.Comparator;
import library.model.Book;

/**
 *
 * @author Silvia Shimabuko
 */
public class ComparatorBookByAuthor implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getFullName().toLowerCase().compareTo(o2.getFullName().toLowerCase());
    }
    
}
