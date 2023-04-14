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
        sb.append("************ Menu ************ \n");
        sb.append("Select an option \n");
        sb.append("0 - Exit \n");
        sb.append("1 - List all Books by Title \n");
        sb.append("2 - List all Books by Author \n");
        sb.append("3 - Search book by title \n");        
        sb.append("4 - Search book by author name \n");
        
        sb.append("5 - List all students by name \n");  
        sb.append("6 - List all students by id \n");
        sb.append("7 - Search for a student by name \n");
        sb.append("8 - Search for a student by Id \n");
       
        
        
        sb.append("9 - Library lend book \n"); 
        sb.append("10 - List books lent to the student \n"); 
        //sb.append("10 - Waiting list \n"); 
        sb.append("11 - Returned books \n");   
        sb.append("12 - My borrowed books \n");        

        return sb.toString();
    }
}
