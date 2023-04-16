/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model.dao;

import java.util.ArrayList;
import java.util.List;
import library.model.Book;
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
                Book book = new Book(data[0], data[1], data[2], data[3], data[4]);
                books.add(book);
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }
    
    public int linearSearch(String targetName, String field) {
        targetName = Commons.removeAccents(targetName);
        
        if (field.equalsIgnoreCase("title")) {
            for (int i = 0; i < books.size(); i++) {
                String title = Commons.removeAccents(books.get(i).getTitle());
                if (title.equalsIgnoreCase(targetName)) {
                    return i;
                }
            }
        }else if(field.equalsIgnoreCase("author")){//search by author
            for (int i = 0; i < books.size(); i++) {
                if (Commons.removeAccents(books.get(i).getFullName()).equalsIgnoreCase(targetName)) {
                    return i;
                }
            }
        }else if(field.equalsIgnoreCase("id")){//search by book id
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getId().equalsIgnoreCase(targetName)) {
                    return i;
                }
            }
        }else{//invalid field
            return -1;
        }
        return -1;
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
    public List<Book> bubbleSorted(List<Book> books,String orderBy) {
        Book temp;
        boolean swap = false;
        do {
            swap = false;
            String s1;
            String s2;

            for (int j = 0; j < books.size() - 1; j++) {

                if (orderBy.equalsIgnoreCase("author")) {
                    s1 = books.get(j).getFullName();
                    s2 = books.get(j + 1).getFullName();
                } else {//order by title
                    s1 = books.get(j).getTitle();
                    s2 = books.get(j + 1).getTitle();
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
