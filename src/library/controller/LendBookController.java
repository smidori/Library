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

    public static final String FILE_LEND = "LEND_BOOK_DATA.csv";

    public List<LendBook> loadDataLendBooks() {
        List<LendBook> lendBooks = new ArrayList<>();
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_LEND);

        if (lines != null) {
            for (String line : lines) {
                String[] data = line.split(",", -1);
                LendBook lendBook = new LendBook(data[0], data[1], Integer.parseInt(data[2]), DateUtils.stringToDate(data[3]), DateUtils.stringToDate(data[4]));
                lendBooks.add(lendBook);
            }
        }
        return lendBooks;
    }

    public int linearSearch(List<LendBook> array, String target) {

        for (int i = 0; i < array.size(); i++) {
            String idBook = array.get(i).getIdBook();
            if (idBook.equalsIgnoreCase(target)) {
                return i;
            }
        }

        return -1;
    }

}
