/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.utilities;

/**
 * This class change the color of the message
 *
 * @author Silvia Shimabuko
 */
public class ColorMessage {

    public static final String RED = "RED";
    public static final String PINK = "PINK";
    public static final String BLUE = "BLUE";
    public static final String GREEN = "GREEN";
    public static final String BOLD_GRAY = "BOLD_GRAY";

    /**
     * Print the message in a different color
     *
     * @param message -> message to be printed in a different color
     * @param color -> should be one of the color above
     */
    public static void print(String message, String color) {
        String colorCode = "\033[0m";
        String colorDefault = "\033[0m";
        if (color != null) {

            switch (color) {
                case RED:
                    colorCode = "\033[31m";
                    break;
                case PINK:
                    colorCode = "\033[35m";
                    break;
                case BLUE:
                    colorCode = "\033[34m";
                    break;
                case GREEN:
                    colorCode = "\033[32m";
                    break;
                case BOLD_GRAY:
                    colorCode = "\033[1;30m";
                    break;
                default:
                    colorCode = "\033[0m";
                    break;
            }
        }
        String[] lines = message.split("\\n");
        for (String l : lines) {
            System.out.println(colorCode + l + colorDefault);
        }
    }
}
