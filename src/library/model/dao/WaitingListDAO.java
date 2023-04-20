/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import library.model.Book;
import library.model.Student;
import library.model.WaitingList;
import library.utilities.Queue;
import library.utilities.ReadCSV;
import library.utilities.WriteCSV;

/**
 *
 * @author Silvia Shimabuko
 */
public class WaitingListDAO {

    public static final String FILE_WAITING_LIST = "WAITING_LIST_DATA.csv";
    private static Map<String, Queue> waitingList;
    private static StudentDAO studentDAO = new StudentDAO();

    public Map<String, Queue> getWaitingList() {
        return waitingList;
    }
    /**
     * load the csv file
     */
    public void loadDataWaitingList() {
        waitingList = new HashMap<>();

        ReadCSV reader = new ReadCSV();
        //the amount of students will be the size of the queue for waiting list book
        int amountStudents = studentDAO.getStudents().size();

        List<String> lines = reader.readFile(FILE_WAITING_LIST);
        if (lines != null) {
            for (String line : lines) {
                String[] data = line.split(",", -1);
                String[] idStudentsStr = data[1].split("\\|");

                Queue idStudents = new Queue(amountStudents);
                for (String idStudentsStr1 : idStudentsStr) {
                    idStudents.Enqueue(idStudentsStr1);
                }
                waitingList.put(data[0], idStudents);
            }
        }
    }

    /**
     * Search the students in the waiting list for an specific idBook
     * @param idBook
     * @return 
     */
    public List<Student> findStudentsWaitingListbyIdBook(String idBook) {
        List<Student> students = new ArrayList<>();

        Queue queue = waitingList.get(idBook);
        if (queue != null) {
            for (int j = 0; j < queue.size(); j++) {
                int idStudent = Integer.parseInt(queue.getData()[j]);
                students.add(studentDAO.findById(idStudent));
            }
        }
        return students;
    }
    
    /**
     * Add student to the waiting list
     * @param student
     * @param book 
     */
    public void add(Student student, Book book) {
        int amountStudents = studentDAO.getStudents().size();
        Queue studentsIdWL = new Queue(amountStudents);
        studentsIdWL.Enqueue(student.getId() + "");
        waitingList.put(book.getId(), studentsIdWL);
    }
    
    /**
     * Remove the first student from the waiting list for a specific book
     * if there is only one in the waiting list, remove this book from the list
     * @param idBook 
     */
    public void removeFirstStudent(String idBook) {
        Queue queue = waitingList.get(idBook);
        if (queue != null) {
            if (queue.size() > 1) {
                queue.Dequeue();
            } else {
                waitingList.remove(idBook);
            }
        }
    }
    
    /**
     * save the list into csv file
     */
    public void save() {
        List<String> datas = new ArrayList<>();
        datas.add(WaitingList.HEAD_CSV);

        for (String key : waitingList.keySet()) {
            datas.add(new WaitingList(key, waitingList.get(key)).getCSVFormat());
        }

        WriteCSV.writefile(WaitingListDAO.FILE_WAITING_LIST, datas);
    }

}
