/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.controller;

import library.model.Student;
import java.util.List;
import library.model.dao.StudentDAO;

/**
 *
 * @author 2022443Maria
 */
public class StudentController {
    private StudentDAO dao = new StudentDAO();
    
    public void loadDataStudents(){
        dao.loadDataStudents();
    }

    public List<Student> bubbleSorted(String orderBy) {
        return dao.bubbleSorted(orderBy);
    }
    
    public String listStudentsAsString(List<Student> students, String orderDescriptionBy) {
        return dao.listStudentsAsString(students, orderDescriptionBy);
    }
    
    public int binarySearch(String targetName, String field) {
        return dao.binarySearch(targetName, field);
    }
    
    public List<Student> getStudents(){
        return dao.getStudents();
    }
    
}
