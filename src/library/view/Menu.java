/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.view;

/**
 *
 * @author Silvia Shimabuko and 2022443Maria
 */
public class Menu {
    public String mainMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("************ Menu ************");
        sb.append("Select the option");
        sb.append("1 - List all Books");
        sb.append("2 - Search book by title");
        sb.append("3 - Search book by author name");
        sb.append("4 - Search for a student by name");
        sb.append("5 - Search for a student by Id");
        sb.append("6 - List all students");   
        sb.append("7 - List all borrowing books"); 
        sb.append("8 - Waiting list"); 
        sb.append("9 - Returned books");   
        sb.append("10 - My borrowed books");        
                
        return sb.toString();
    }
}
