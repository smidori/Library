/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Convert the date to string and vice versa
 * @author Silvia Shimabuko
 */
public class DateUtils {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final DateTimeFormatter DATE_HOUR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * Convert the date to String including seconds
     * @param date
     * @return 
     */
    public static String dateToString(LocalDateTime date) {
        if (date == null) {
            return "";
        }
        return date.format(DATE_FORMAT);
    }

    /**
     * Convert the date to string including minutes
     * @param date
     * @return 
     */
    public static String dateToStringDateHour(LocalDateTime date) {
        if (date == null) {
            return "";
        }
        return date.format(DATE_HOUR);
    }
    
    /**
     * Convert the string into date
     * @param date
     * @return 
     */
    public static LocalDateTime stringToDate(String date) {
        if(date == null || date.equals("")){
            return null;
        }
        return LocalDateTime.parse(date, DATE_FORMAT);
    }

}
