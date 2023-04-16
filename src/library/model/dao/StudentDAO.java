/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model.dao;

import java.util.ArrayList;
import java.util.List;
import library.model.Student;
import library.utilities.Commons;
import library.utilities.ReadCSV;

/**
 *
 * @author Silvia Shimabuko
 */
public class StudentDAO {
    public static final String FILE_STUDENT = "STUDENTS_DATA.csv";
    private static List<Student> students;
            
    public void loadDataStudents() {
        students = new ArrayList<>();
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_STUDENT);

        if (lines != null) {
            for (String line : lines) {

                String[] data = line.split(",");

                Student student = new Student(Integer.parseInt(data[0]), data[1], data[2], data[3]);
                students.add(student);
            }
        }
    }
    
    public Student findById(int idStudent){
        if(!students.isEmpty()){
            for (Student student : students) {
                if(student.getId() == idStudent){
                    return student;
                }
            }
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }
    
    public List<Student> bubbleSorted(List<Student> students, String orderBy) {
        Student temp;
        boolean swap;
        do {
            swap = false;
            String s1;
            String s2;

            for (int j = 0; j < students.size() - 1; j++) {

                if (orderBy.equalsIgnoreCase("name")) {
                    s1 = students.get(j).getFullName();
                    s2 = students.get(j + 1).getFullName();
                } else {//order by id
                    s1 = students.get(j).getId() + "";
                    s2 = students.get(j + 1).getId() + "";
                }

                int compare = s1.compareTo(s2);

                if (compare > 0) { //s1 > s2
                    temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                    swap = true;
                }
            }
        } while (swap);
        return students;
    }
    
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
    
    public int linearSearch(List<Student> array, String targetName, String field) {
        targetName = Commons.removeAccents(targetName);
        
        if (field.equalsIgnoreCase("name")) {
            for (int i = 0; i < array.size(); i++) {
                String title = Commons.removeAccents(array.get(i).getFullName());
                if (title.equalsIgnoreCase(targetName)) {
                    return i;
                }
            }
        }else if(field.equalsIgnoreCase("id")){//search by student id
            int idStudent = Integer.parseInt(targetName);
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).getId() == idStudent) {
                    return i;
                }
            }
        }else{//invalid field
            return -1;
        }
        return -1;
    }
}
