/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model.dao;

import java.util.ArrayList;
import java.util.List;
import library.comparator.ComparatorStudentByName;
import library.model.Student;
import library.utilities.BinarySearch;
import library.utilities.MergeSort;
import library.utilities.ReadCSV;

/**
 *
 * @author Silvia Shimabuko
 */
public class StudentDAO {

    public static final String FILE_STUDENT = "STUDENTS_DATA.csv";
    private static List<Student> students;

    public List<Student> getStudents() {
        return students;
    }
    
    /**
     * load csv data file into java
     */
    public void loadDataStudents() {
        students = new ArrayList<>();
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_STUDENT);

        if (lines != null) {
            for (String line : lines) {

                String[] data = line.split(",");

                Student student = new Student(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]);
                students.add(student);
            }
        }
    }

    /**
     * Find student by id
     * @param idStudent
     * @return 
     */
    public Student findById(int idStudent) {
        if (!students.isEmpty()) {
            for (Student student : students) {
                if (student.getId() == idStudent) {
                    return student;
                }
            }
        }
        return null;
    }

    /**
     * Use to sort the list, based on the the orderBy parameter
     * @param orderBy
     */
    public void mergeSort(String orderBy) {
         if (orderBy.equalsIgnoreCase("name")) {
            MergeSort.divideMerge(students,new ComparatorStudentByName());
        } else {//order by id
            MergeSort.divideMerge(students,null);
        }
    }
    
    /**
     * Find the element based on the field that was choosen
     * @param target
     * @param field
     * @return 
     */
    public int binarySearch(String target, String field) {
        mergeSort(field);//sort the list before do the search
        Student student = new Student();
        
        if (field.equalsIgnoreCase("name")) {
            student.setFirstName(target.split(" ")[0]);
            student.setLastName(target.split(" ")[1]);
            return BinarySearch.binarySearch(students, student, new ComparatorStudentByName());
        } else if (field.equalsIgnoreCase("id")) {//search by student id
            student.setId(Integer.parseInt(target));
            return BinarySearch.binarySearch(students, student, null);
        } else {//invalid field
            return -1;
        }
    }

    /**
     * Convert the list of students to String, needs to pass the list because it would 
     * be used for a students list present in waiting list 
     * @param students
     * @param orderDescriptionBy
     * @return 
     */
    public String listStudentsAsString(List<Student> students, String orderDescriptionBy) {
        StringBuilder sb = new StringBuilder();

        if (students == null || students.isEmpty()) {
            return "Student not found :(";
        }

        for (Student s : students) {
            sb.append(s.orderedDescriptionBy(orderDescriptionBy));
        }
        return sb.toString();
    }

}
