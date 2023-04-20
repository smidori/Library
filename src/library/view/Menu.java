/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.view;

import library.utilities.ColorMessage;

/**
 *
 * @author Silvia Shimabuko and 2022443Maria
 */
public class Menu {
     public String mainMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n************ Menu ************ \n");
        sb.append(" 0 - Exit \n");
        sb.append(" 1 - List all books by title \n");
        sb.append(" 2 - List all books by author \n");
        sb.append(" 3 - Search book by title \n");        
        sb.append(" 4 - Search book by author \n");
        sb.append(" 5 - Search book by id \n");
        
        sb.append(" 6 - List all students by name \n");  
        sb.append(" 7 - List all students by id \n");
        sb.append(" 8 - Search for a student by name \n");
        sb.append(" 9 - Search for a student by Id \n");

        sb.append("10 - Lend book \n"); 
        sb.append("11 - Return books \n");       
        sb.append("12 - Books lent to the student \n"); 
        sb.append("13 - Search waiting list by book id\n"); 
        sb.append("14 - Remove 1° student from Waiting List\n"); 
        sb.append("Select an option: \n");
        return sb.toString();
    }
     
    public static void printItemNotFound(String object, String target){
        String message = "\nSorry, "+object+" [" + target + "] not found :( \n";
        ColorMessage.print(message, ColorMessage.PINK);
    }
    
    public static void printSearching(String object){
        String message = "\nSearching for the "+object+"...\n";
        ColorMessage.print(message, ColorMessage.BOLD_GRAY);
    }
}
