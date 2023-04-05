/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.view;

/**
 *
 * @author Silvia Shimabuko
 */
public class Menu {
    public String mainMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("************ Menu ************");
        sb.append("Select the option");
        sb.append("1 - List all Books");
        sb.append("2 - Search book by name");
        return sb.toString();
    }
}
