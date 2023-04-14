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

    public List<Student> loadDataStudents() {
        List<Student> students = new ArrayList<>();
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_STUDENT);

        if (lines != null) {
            for (String line : lines) {

                String[] data = line.split(",");

                Student student = new Student(Integer.parseInt(data[0]), data[1], data[2], data[3]);
                students.add(student);
            }
        }

        return students;
    }

    public List<Student> bubbleSorted(List<Student> array, String orderBy) {
        Student temp;
        boolean swap;
        do {
            swap = false;
            String s1;
            String s2;

            for (int j = 0; j < array.size() - 1; j++) {

                if (orderBy.equalsIgnoreCase("name")) {
                    s1 = array.get(j).getFullName();
                    s2 = array.get(j + 1).getFullName();
                } else {//order by title
                    s1 = array.get(j).getId() + "";
                    s2 = array.get(j + 1).getId() + "";
                }

                int compare = s1.compareTo(s2);

                if (compare > 0) { //s1 > s2
                    temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                    swap = true;
                }
            }
        } while (swap);
        System.out.println("-----------");
        return array;
    }
}
