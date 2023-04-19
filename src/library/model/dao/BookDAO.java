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
import library.utilities.ReadCSV;

/**
 *
 * @author Silvia Shimabuko
 */
public class BookDAO {
    public static final String FILE_BOOK = "BOOKS_DATA.csv";
    private static List<Book> books;
    
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
    
    public int binarySearch(String targetName, String field) {
        targetName = Commons.removeAccents(targetName);
        Book target = new Book();
        bubbleSorted(field); //need to sort before to search in a binary search
        
        if (field.equalsIgnoreCase("title")) {    
            target.setTitle(targetName);
            return BinarySearch.binarySearch(books, target, new ComparatorBookByTitle());
        }else if(field.equalsIgnoreCase("author")){//search by author
            target.setAuthorFirstName(targetName.split(" ")[0]);
            target.setAuthorLastName(targetName.split(" ")[1]);
            return BinarySearch.binarySearch(books, target, new ComparatorBookByAuthor());
        }else if(field.equalsIgnoreCase("id")){//search by book id
            target.setId(targetName);
            return BinarySearch.binarySearch(books, target, null);
        }else{//invalid field
            return -1;
        }
    }
    
    public String listBooksAsString(List<Book> books,String orderDescriptionBy) {
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
    public List<Book> bubbleSorted(String orderBy) {
        Book temp;
        boolean swap = false;
        do {
            swap = false;
            String s1;
            String s2;

            for (int j = 0; j < books.size() - 1; j++) {

                if (orderBy.equalsIgnoreCase("author")) {
                    s1 = Commons.removeAccents(books.get(j).getFullName());
                    s2 = Commons.removeAccents(books.get(j + 1).getFullName());
                } else if (orderBy.equalsIgnoreCase("title")) {//order by title  
                    s1 = Commons.removeAccents(books.get(j).getTitle());
                    s2 = Commons.removeAccents(books.get(j + 1).getTitle());
                } else {//order by title  
                    s1 = books.get(j).getId();
                    s2 = books.get(j + 1).getId();
                }

                int compare = s1.compareTo(s2);

                if (compare > 0) { //s1 > s2
                    temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                    swap = true;
                }
            }
        } while (swap);
        return books;
    }

}
