/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.controller;

import library.model.Student;
import java.util.ArrayList;
import java.util.List;
import library.utilities.ReadCSV;

/**
 *
 * @author 2022443Maria
 */
public class StudentController {
  
     public static final String FILE_STUDENT = "STUDENTS_DATA.csv";
    
     public List<Student> loadDataStudents(){
        List<Student> students = new ArrayList<>();
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_STUDENT);
        
        if(lines != null){
            for(String line: lines){
             
                String[] data = line.split(",");
                
                Student student = new Student(Integer.parseInt(data[0]),data[1],data[2], data[3]);
                students.add(student);
            }
        }
        
        return students;
     }
     
}
