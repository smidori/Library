/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model;

/**
 *
 * @author Silvia Shimabuko
 */
public class Book {
    private String id;
    private String authorFirstName;
    private String authorLastName;
    private String title;
    private String genre; // create enum ????
    private boolean isAvailable;

    //CONSTRUCTOR
    public Book(String id, String authorFirstName, String authorLastName, String title, String genre, boolean isAvailable) {
        this.id = id;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.title = title;
        this.genre = genre;
        this.isAvailable = isAvailable;
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

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public String getFullName() {
        return authorFirstName + " " + authorLastName;
    }
     
    @Override
    public String toString(){
        return "Title: " + title + "\nAuthor: " + getFullName() + "\ngenre(s): " + genre;
        //return title + " ("+ getFullName() +")" + " genre: "+ genre +"\n";
    }
    
    
    public String orderedDescriptionBy(String order){
        if(order.equalsIgnoreCase("author")){
            return getFullName() +" - " + title +"\n";
        }else if(order.equalsIgnoreCase("title")){
            return title + " - ("+ getFullName() +")\n";
        }else{
            return toString();
        }
    }
    
}
