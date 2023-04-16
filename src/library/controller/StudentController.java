/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.controller;

import library.model.Student;
import java.util.List;
import library.model.dao.StudentDAO;
import library.utilities.Commons;

/**
 *
 * @author 2022443Maria
 */
public class StudentController {
    private StudentDAO dao = new StudentDAO();
    
    public void loadDataStudents(){
        dao.loadDataStudents();
    }

    public List<Student> bubbleSorted(List<Student> students,String orderBy) {
        return dao.bubbleSorted(students,orderBy);
    }
    
    public String listStudentsAsString(List<Student> students, String orderDescriptionBy) {
        return dao.listStudentsAsString(students, orderDescriptionBy);
    }
    
    public int linearSearch(List<Student> array, String targetName, String field) {
        return dao.linearSearch(array, targetName, field);
    }
    
    public List<Student> getStudents(){
        return dao.getStudents();
    }
    
}
