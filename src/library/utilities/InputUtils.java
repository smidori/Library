/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library.utilities;

import java.util.Scanner;

/**
 *
 * @author Silvia Shimabuko
 */
public class InputUtils {

    /**
     * Prompt user to enter an integer within a given range, keep asking while
     * the number is invalid
     *
     * @param prompt the message that should print
     * @param minValue the minimum value allowed
     * @param maxValue the maximum value allowed
     * @param color color of the message to be printed, case null, will be printed in black
     * @return the valid user input
     */
    public static int getUserIntBetween(String prompt, int minValue, int maxValue, String color) {

        Scanner myKB = new Scanner(System.in);
        int userInput = 0;
        boolean valid = false;
        do {
            ColorMessage.print(prompt, color);

            try {
                userInput = myKB.nextInt(); //get a int
                valid = true;
            } catch (Exception e) {//throws exception in case the input wasn't a number
                ColorMessage.print("The number must be between " + minValue + " and " + maxValue, ColorMessage.PINK);
                myKB.nextLine(); //force to enter a number
            }
        } while ((!valid) || (userInput < minValue) || (userInput > maxValue));//keep asking a number in case it wasn't valid

        return userInput;
    }
    
    public static int getUserInt(String prompt, String color) {

        Scanner myKB = new Scanner(System.in);
        int userInput = 0;
        boolean valid = false;

        do {
            //System.out.println("\n*********");
            //System.out.println(prompt);
            ColorMessage.print(prompt, color);
            //System.out.println("*********");
            try {
                userInput = myKB.nextInt(); //get a int
                valid = true;
            } catch (Exception e) {//throws exception in case the input wasn't a number
                ColorMessage.print("The number is invalid", ColorMessage.PINK);
                myKB.nextLine(); //force to enter a number
            }
        } while (!valid);//keep asking a number in case it wasn't valid

        return userInput;
    }

    public static String getUserText(String prompt, String color) {
        Scanner myKB = new Scanner(System.in,"ISO_8859_1");
        String userInput;
        
        //System.out.println(prompt);
        ColorMessage.print(prompt, color);
        userInput = myKB.nextLine().trim(); // get input
        return userInput;

    }
    
    public static boolean getUserPressEnter() {
        String prompt = "\nPress \"Enter key\" to show the options";
        Scanner myKB = new Scanner(System.in);
        boolean valid = false; //assume not valid
        String userInput;

        do {

            //System.out.println(prompt);
            ColorMessage.print(prompt,ColorMessage.BLUE);
            
            userInput = myKB.nextLine().trim(); // get input

            if (userInput.matches("^\\r?$")) {
                //this is valid input
                valid = true;
            } else {
                //not valid text
                System.err.println("Invalid - press enter key only please");
            }

        } while (!valid); //keep going until valid input received

        return valid;

    }

}
