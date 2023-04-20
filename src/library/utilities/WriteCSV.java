/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silvia Shimabuko
 */
public class WriteCSV {

    public static void writefile(String fileName, List<String> datas) {
        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + "//src//files//" + fileName;
        File file = new File(filePath);

        if (file.exists()) {
            file.renameTo(new File(filePath + "_bkp"));
        }

        try {
            FileWriter writer = new FileWriter(file);
            for (String s : datas) {
                writer.write(s);
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteCSV.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error to write in the file " + fileName + ", please close the file");
        }

    }

}
