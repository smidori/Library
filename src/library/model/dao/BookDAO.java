/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model.dao;

import java.util.ArrayList;
import java.util.List;
import library.comparator.ComparatorBookByAuthor;
import library.comparator.ComparatorBookByTitle;
import library.model.Book;
import library.utilities.BinarySearch;
import library.utilities.Commons;
import library.utilities.MergeSort;
import library.utilities.ReadCSV;

/**
 *
 * @author Silvia Shimabuko
 */
public class BookDAO {
    
    public static final String FILE_BOOK = "BOOKS_DATA.csv";
    private static List<Book> books;
    
    /**
     * Load csv data file into java
     */
    public void loadDataBooks() {
        books = new ArrayList<>();
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_BOOK);

        if (lines != null) {
            for (String line : lines) {
                //this pattern is to ignore to split by comma when it is inside of quotes
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Book book = new Book(data[0], data[1], data[2], data[3].replace("\"", ""), data[4]);
                books.add(book);
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }
    /**
     * Search the target based on the field was choosen
     * @param targetName - word that needs to be find
     * @param field - used to choose which comparator will be used
     * @return 
     */
    public int binarySearch(String targetName, String field) {
        targetName = Commons.removeAccents(targetName);
        Book target = new Book();
        mergeSort(field); //need to sort before to search in a binary search

        if (field.equalsIgnoreCase("title")) {
            target.setTitle(targetName);
            return BinarySearch.binarySearch(books, target, new ComparatorBookByTitle());
        } else if (field.equalsIgnoreCase("author")) {//search by author
            target.setAuthorFirstName(targetName.split(" ")[0]);
            target.setAuthorLastName(targetName.split(" ")[1]);
            return BinarySearch.binarySearch(books, target, new ComparatorBookByAuthor());
        } else if (field.equalsIgnoreCase("id")) {//search by book id
            target.setId(targetName);
            return BinarySearch.binarySearch(books, target, null);
        } else {//invalid field
            return -1;
        }
    }
    
    /**
     * Convert the list of books into string
     * @param books
     * @param orderDescriptionBy
     * @return 
     */
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

    /**
     * Use the algorithm mergeSort
     * @param orderBy -> field that will be used to sort
     */
    public void mergeSort(String orderBy) {
        
        if (orderBy.equalsIgnoreCase("author")) {
            MergeSort.divideMerge(books, new ComparatorBookByAuthor());
          
        } else if (orderBy.equalsIgnoreCase("title")) {//order by title  
            MergeSort.divideMerge(books, new ComparatorBookByTitle());
        } else {//order by id 
            MergeSort.divideMerge(books, null);
        }
    }
    
    /**
     * This method do not ignore the accent
     * @param target
     * @return 
     */
    public List<Book> findBookContains(String target) {
        List<Book> booksSearched = new ArrayList<>();
        target = target.toLowerCase();

        for (Book b : books) {
            String title = b.getTitle().toLowerCase();
            if (title.contains(target)
                    || b.getFullName().toLowerCase().contains(target)
                    || b.getId().toLowerCase().contains(target)) {
                booksSearched.add(b);
            }
        }
        return booksSearched;
    }

}
