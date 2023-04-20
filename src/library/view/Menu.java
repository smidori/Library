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
        String stars = "***********************************************************";
        sb.append("\n"+stars+" MENU "+stars+"\n");
        
        String fmt = "%-37s";
        String bTitle = String.format(fmt, "         -- BOOK --");
        String b1 = String.format(fmt, " 1 - List all ordered by title");
        String b2 = String.format(fmt, " 2 - List all ordered by author");
        String b3 = String.format(fmt, " 3 - Search by title");
        String b4 = String.format(fmt, " 4 - Search by author");
        String b5 = String.format(fmt, " 5 - Search by id");
        String b6 = String.format(fmt, " 6 - Search by word"); 
        
        String sTitle = String.format(fmt, "         -- STUDENTS --");
        String s1 = String.format(fmt, " 7 - List all students by name");
        String s2 = String.format(fmt, " 8 - List all students by id");
        String s3 = String.format(fmt, " 9 - Search for a student by name");
        String s4 = String.format(fmt, "10 - Search for a student by Id");
        String s5 = String.format(fmt, "");
        String s6 = String.format(fmt, "");
        
        String lrTitle = String.format(fmt, "         -- LENDING & RETURN --");
         String lr1 = String.format(fmt, "11 - Lend book");
        String lr2 = String.format(fmt, "12 - Return books");
        String lr3 = String.format(fmt, "13 - Books lent to the student");
        String lr4 = String.format(fmt, "14 - Search waiting list by book id");
        String lr5 = String.format(fmt, "15 - Remove 1° student from Waiting List");
        String lr6 = String.format(fmt, "");
     
        
        
        
        sb.append(bTitle + "| " + sTitle + "| " + lrTitle +"\n");  
        sb.append(b1 + "| " + s1 + "| " + lr1 + "\n");
        sb.append(b2 + "| " + s2 + "| " + lr2 + "\n");
        sb.append(b3 + "| " + s3 + "| " + lr3 + "\n");
        sb.append(b4 + "| " + s4 + "| " + lr4 + "\n");
        sb.append(b5 + "| " + s5 + "| " + lr5 + "\n");
        sb.append(b6 + "| " + s6 + "| " + lr6 + "\n\n");
        sb.append(" 0 - Exit \n");
        

        
        
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
