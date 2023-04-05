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
            System.out.println("\n*********");
            System.out.println(prompt);
            System.out.println("*********");
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

}
