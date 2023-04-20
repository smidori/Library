/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.view;

import java.util.List;
import library.controller.StudentController;
import library.model.Student;
import library.utilities.ColorMessage;
import library.utilities.InputUtils;

/**
 *
 * @author Silvia Shimabuko
 */
public class StudentView {

    private static final StudentController sc = new StudentController();

    public Student searchStudentById() {
        int searchId = InputUtils.getUserInt("Type the id of the student", ColorMessage.BLUE);
        Menu.printSearching("student");

        int indexStudent = sc.binarySearch(String.valueOf(searchId), "id");
        if (indexStudent < 0) {
            Menu.printItemNotFound("student", String.valueOf(searchId));
            return null;
        } else {
            return sc.getStudents().get(indexStudent);
        }
    }
    /**
     * List students with the fields in different position depends on the field parameter
     * @param students
     * @param field 
     */
    public void listStudents(List<Student> students, String field) {
        if (field.equalsIgnoreCase("name")) {
            ColorMessage.print("Name\t-\tId\t-\tEmail\t-\tAddress \n", ColorMessage.BOLD_GRAY);
        } else {
            ColorMessage.print("Id\t-\tName\t-\tEmail\t-\tAddress \n", ColorMessage.BOLD_GRAY);
        }
        System.out.println(sc.listStudentsAsString(students, field));
    }

    /**
     * Search the student based the field in the menu option selected
     * @param field 
     */
    public void search(String field) {
        String target = "";
        
        if (field.equalsIgnoreCase("name")) {
            boolean invalid; //used to control if typed a full name (names between spaces)
            do{
                invalid = false;
                String searchName = InputUtils.getUserText("Type the student " + field, ColorMessage.BLUE);
                target = searchName;
                //check if it's a full name
                if(!target.trim().contains(" ")){
                    ColorMessage.print("Please, type first and last name", ColorMessage.PINK);
                    invalid = true;
                }
            }while(invalid);
            
        } else { //search by id
            int searchId = InputUtils.getUserInt("Type the student " + field, ColorMessage.BLUE);
            target = String.valueOf(searchId);
        }

        Menu.printSearching("student");
        int indexStudent = sc.binarySearch(target, field);
        if (indexStudent < 0) {
            Menu.printItemNotFound("student", target);
        } else {
            System.out.println("STUDENT \n" + sc.getStudents().get(indexStudent).toString() + "\n");
        }
    }
}
