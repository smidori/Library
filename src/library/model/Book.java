/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model;

/**
 * This class implements the Comparable for the binary search and merge sort
 * @author Silvia Shimabuko
 */
public class Book implements Comparable<Book>{
    private String id;
    private String authorFirstName;
    private String authorLastName;
    private String title;
    private String genre; 

    //CONSTRUCTORES
    public Book() {}//necessary for comparator class, to set the property that needs to be search

    public Book(String id, String authorFirstName, String authorLastName, String title, String genre) {
        this.id = id;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.title = title;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String bookTitle) {
        this.title = bookTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getFullName() {
        return authorFirstName + " " + authorLastName;
    }
     
    @Override
    public String toString(){
        return "Title: " + title +"\nId: "+getId() +"\nAuthor: " + getFullName() + "\nGenre(s): " + genre;
    }
    
    
    public String orderedDescriptionBy(String order){
        if(order.equalsIgnoreCase("author")){
            return id + " - " +getFullName() +" - " + title +"\n";
        }else if(order.equalsIgnoreCase("title")){
            return id + " - " +title + " - ("+ getFullName() +")\n";
        }else{
            return toString();
        }
    }

    @Override
    public int compareTo(Book o) {
        return id.compareTo(o.getId());
    }
    
}
