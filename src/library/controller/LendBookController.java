/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.controller;

import java.util.ArrayList;
import java.util.List;
import library.model.LendBook;
import library.utilities.DateUtils;
import library.utilities.ReadCSV;

/**
 *
 * @author Silvia Shimabuko
 */
public class LendBookController {

    public static final String FILE_LEND_BOOK = "LEND_BOOK_DATA.csv";

    public List<LendBook> loadDataLendBooks() {
        List<LendBook> lendBooks = new ArrayList<>();
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_LEND_BOOK);

        if (lines != null) {
            for (String line : lines) {
                String[] data = line.split(",", -1);
                LendBook lendBook = new LendBook(data[0], data[1], Integer.parseInt(data[2]), DateUtils.stringToDate(data[3]), DateUtils.stringToDate(data[4]));
                lendBooks.add(lendBook);
            }
        }
        return lendBooks;
    }

//    public int linearSearch(List<LendBook> array, String target, String field) {
//        //targetName = Commons.removeAccents(targetName);
//        
//        if (field.equalsIgnoreCase("idBook")) {
//            for (int i = 0; i < array.size(); i++) {
//                String idBook = array.get(i).getIdBook();
//                if (idBook.equalsIgnoreCase(target)) {
//                    return i;
//                }
//            }
//        }else if(field.equalsIgnoreCase("idStudent")){//search by idStudent
//            int idStudent = Integer.parseInt(target);
//            
//            for (int i = 0; i < array.size(); i++) {
//                if (array.get(i).getIdStudent() == (idStudent)) {
//                    return i;
//                }
//            }
//        }else{//invalid field
//            return -1;
//        }
//        return -1;
//    }

    public int linearSearchBook(List<LendBook> array, String idBook, boolean isLent) {
        for (int i = array.size() -1; i >= 0; i--) {//TODO SEARCH FROM MOST RECENT TO THE OLD
            LendBook lendBook = array.get(i);
            if(isLent){//it will return the book in case the book is lent already, it means with return date null
                if (lendBook.getIdBook().equalsIgnoreCase(idBook) && lendBook.getReturnDate() == null ) {
                    return i;
                }
            }else{
                if (lendBook.getIdBook().equalsIgnoreCase(idBook) && lendBook.getReturnDate() != null ) {
                    return i;
                }
            }
            
        }
        return -1;
    }
    
    public List<LendBook> linearSearch(List<LendBook> array, int idStudent) {
        List<LendBook> lendBooks = new ArrayList<>();
        
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getIdStudent() == idStudent) {
                lendBooks.add(array.get(i));
            }
        }
        return lendBooks;
    }

}
