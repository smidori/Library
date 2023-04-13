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

    public List<Book> loadDataBooks() {
        List<Book> books = new ArrayList<>();
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_BOOK);

        if (lines != null) {
            for (String line : lines) {
                //this pattern is to ignore to split by comma when it is inside of quotes
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                boolean isAvailable = data[5].equals("true");
                Book book = new Book(data[0], data[1], data[2], data[3], data[4], isAvailable );
                books.add(book);
            }
        }

        return books;
    }

    public String listBooksAsString(List<Book> books, String orderDescriptionBy) {
        StringBuilder sb = new StringBuilder();

        if (books == null || books.isEmpty()) {
            return "Book not found :(";
        }

        for (Book b : books) {
            sb.append(b.orderedDescriptionBy(orderDescriptionBy));
        }
        return sb.toString();
    }

    //Used do/while because it is faster then nested for
    public List<Book> bubbleSorted(List<Book> array, String orderBy) {
        Book temp;
        boolean swap = false;
        do {
            swap = false;
            String s1;
            String s2;

            for (int j = 0; j < array.size() - 1; j++) {

                if (orderBy.equalsIgnoreCase("author")) {
                    s1 = array.get(j).getFullName();
                    s2 = array.get(j + 1).getFullName();
                } else {//order by title
                    s1 = array.get(j).getTitle();
                    s2 = array.get(j + 1).getTitle();
                }

                int compare = s1.compareTo(s2);

                if (compare > 0) { //s1 > s2
                    temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                    swap = true;
                }
            }
        } while (swap);
        System.out.println("-----------");
        return array;
    }

    //TODO
    /**
     * Visit every position in the array, until find the element that matches with the criteria
     * @param array
     * @param targetName
     * @param field
     * @return 
     */
    public int linearSearch(List<Book> array, String targetName, String field) {
        //targetName = Commons.removeAccents(targetName);
        
        if (field.equalsIgnoreCase("title")) {
            for (int i = 0; i < array.size(); i++) {
                //String title = Commons.removeAccents(array.get(i).getTitle());
                String title = array.get(i).getTitle();
                if (title.equalsIgnoreCase(targetName)) {
                    return i;
                }
            }
        }else if(field.equalsIgnoreCase("author")){//search by author
            for (int i = 0; i < array.size(); i++) {
                //if (Commons.removeAccents(array.get(i).getFullName()).equalsIgnoreCase(targetName)) {
                if (array.get(i).getFullName().equalsIgnoreCase(targetName)) {
                    return i;
                }
            }
        }else{//invalid field
            return -1;
        }
        return -1;
    }
}