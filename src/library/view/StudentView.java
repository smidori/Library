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

    public void listStudents(List<Student> students, String field) {
        if (field.equalsIgnoreCase("name")) {
            ColorMessage.print("Name\t-\tId\t-\tEmail\t-\tAddress \n", ColorMessage.BOLD_GRAY);
        } else {
            ColorMessage.print("Id\t-\tName\t-\tEmail\t-\tAddress \n", ColorMessage.BOLD_GRAY);
        }
        System.out.println(sc.listStudentsAsString(students, field));
    }

    public void search(String field) {
        String target = "";
        if (field.equalsIgnoreCase("name")) {
            String searchName = InputUtils.getUserText("Type the student " + field, ColorMessage.BLUE);
            target = searchName;
        } else {
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
