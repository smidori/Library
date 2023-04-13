/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Silvia Shimabuko
 */
public class DateUtils {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static String dateToString(LocalDateTime date) {
        if (date == null) {
            return "";
        }
        return date.format(DATE_FORMAT);
    }

    public static LocalDateTime stringToDate(String date) {
        if(date == null || date.equals("")){
            return null;
        }
        return LocalDateTime.parse(date, DATE_FORMAT);
    }

}
