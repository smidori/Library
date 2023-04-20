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
        boolean invalidRange = false;
        do {
            ColorMessage.print(prompt, color);
            try {
                userInput = myKB.nextInt(); //get a int
                valid = true;
                invalidRange = (userInput < minValue) || (userInput > maxValue);
                if(invalidRange){
                    ColorMessage.print("The number must be between " + minValue + " and " + maxValue, ColorMessage.PINK);
                }
            } catch (Exception e) {//throws exception in case the input wasn't a number
                ColorMessage.print("The number must be between " + minValue + " and " + maxValue, ColorMessage.PINK);
                myKB.nextLine(); //force to enter a number
            }
        } while ((!valid) || invalidRange );//keep asking a number in case it wasn't valid

        return userInput;
    }
    
    /**
     * Ask the user to type a number
     * @param prompt
     * @param color
     * @return 
     */
    public static int getUserInt(String prompt, String color) {

        Scanner myKB = new Scanner(System.in);
        int userInput = 0;
        boolean valid = false;

        do {
            ColorMessage.print(prompt, color);

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

    /**
     * Ask to user to type some text
     * @param prompt
     * @param color
     * @return 
     */
    public static String getUserText(String prompt, String color) {
        String userInput;
        boolean invalid;
        do{
            invalid = false;
            //used the charset to treat when the user type words with accents
            Scanner myKB = new Scanner(System.in, "ISO_8859_1");
            ColorMessage.print(prompt, color);
            userInput = myKB.nextLine().trim(); // get input
            
            if (userInput.length() == 0) {
                ColorMessage.print("Invalid text ", ColorMessage.PINK);
                invalid = true;
            }
        }while(invalid);
        
        return userInput;
    }
    
    /**
     * Ask to use press enter to show the menu again
     * @return 
     */
    public static boolean getUserPressEnter() {
        String prompt = "\nPress \"Enter key\" to show the options";
        Scanner myKB = new Scanner(System.in);
        boolean valid = false; //assume not valid
        String userInput;

        do {
            ColorMessage.print(prompt,ColorMessage.BLUE);
            
            userInput = myKB.nextLine().trim(); // get input

            if (userInput.matches("^\\r?$")) {
                //this is valid input
                valid = true;
            } else {
                //not valid key
                System.err.println("Invalid - press enter key only please");
            }
        } while (!valid); //keep going until valid input received

        return valid;

    }

}
