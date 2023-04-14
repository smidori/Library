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
     * @return the valid user input
     */
    public static int getUserInt(String prompt, int minValue, int maxValue) {

        Scanner myKB = new Scanner(System.in);
        int userInput = 0;
        boolean valid = false;

        do {
            //System.out.println("\n*********");
            System.out.println(prompt);
            //System.out.println("*********");
            try {
                userInput = myKB.nextInt(); //get a int
                valid = true;
            } catch (Exception e) {//throws exception in case the input wasn't a number
                System.out.println("The number must be between " + minValue + " and " + maxValue);
                myKB.nextLine(); //force to enter a number
            }
        } while ((!valid) || (userInput < minValue) || (userInput > maxValue));//keep asking a number in case it wasn't valid

        return userInput;
    }

    public static String getUserText(String prompt) {
        Scanner myKB = new Scanner(System.in,"ISO_8859_1");
        String userInput;
        
        System.out.println(prompt);
        userInput = myKB.nextLine().trim(); // get input
        return userInput;

    }
    
    public static boolean getUserPressEnter() {
        String prompt = "\nPress \"Enter key\" to show the options";
        Scanner myKB = new Scanner(System.in);
        boolean valid = false; //assume not valid
        String userInput;

        do {

            System.out.println(prompt);

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

    /**
     * Prompt user to enter an text and keep asking if the text is invalid
     *
     * @param prompt
     * @return
     */
    public static String getUserTextOld(String prompt) {

        Scanner myKB = new Scanner(System.in);
        boolean valid = false; //assume not valid
        String userInput;

        do {

            System.out.println(prompt);

            userInput = myKB.nextLine().trim(); // get input

            if (userInput.matches("[a-zA-Z ]+")) {
                //this is valid input
                valid = true;
            } else {
                //not valid text
                System.out.println("Invalid - enter text only please");
            }

        } while (!valid); //keep going until valid input received

        return userInput;

    }
}
