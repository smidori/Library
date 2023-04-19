/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.comparator;

import java.util.Comparator;
import library.model.Book;
import library.utilities.Commons;

/**
 *
 * @author Silvia Shimabuko
 */
public class ComparatorBookByTitle implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        String title1 = Commons.removeAccents(o1.getTitle().toLowerCase());
        String title2 = Commons.removeAccents(o2.getTitle().toLowerCase());
        return title1.compareTo(title2);
    }
}
