package library.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Silvia Shimabuko
 */
public class ReadCSV {

    public List<String> readFile(String fileName) {
            List<String> lines = new ArrayList<>();
            
        try {
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + "//src//files//" + fileName;
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String line = scanner.next();
                //replace any carriage return if found
                lines.add(line.replace("\r", ""));
            }
            lines.remove(0); //remove header
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File "+ fileName + " not found");
        }
        return lines;
    }
}
