/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model.dao;

import java.util.ArrayList;
import java.util.List;
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
    private static List<WaitingList> waitingList; 
    private static StudentDAO studentDAO = new StudentDAO();
    
    public List<WaitingList> getWaitingList() {
        return waitingList;
    }
    
    public void loadDataWaitingList() {
        waitingList = new ArrayList<>();
        ReadCSV reader = new ReadCSV();
        //the amount of students will be the size of the queue for waiting list book
        int amountStudents = studentDAO.getStudents().size();        
        
        List<String> lines = reader.readFile(FILE_WAITING_LIST);
        if (lines != null) {
            for (String line : lines) {
                String[] data = line.split(",",-1);
                String[] idStudentsStr = data[1].split("\\|");
                
                Queue idStudents = new Queue(amountStudents);
                for (String idStudentsStr1 : idStudentsStr) {
                    idStudents.Enqueue(idStudentsStr1);
                }
                
                WaitingList wl = new WaitingList(data[0], idStudents);
                waitingList.add(wl);
            }
        }
    }
    
    public List<Student> findStudentsWaitingListbyIdBook(String target) {
        List<Student> students = new ArrayList<>();
        //TODO TRAZER OS DADOS PREVIAMENTE
        
        for (int i = 0; i < waitingList.size(); i++) {
            WaitingList wl = waitingList.get(i);
            if (wl.getIdBook().equalsIgnoreCase(target)) {
                Queue queue = wl.getStudents();
                while(queue.size() > 0){
                    //TODO LOAD THE STUDENT
                    int idStudent = Integer.parseInt(queue.Dequeue());
                    students.add(studentDAO.findById(idStudent));
                }
            }
        }

        return students;
    }

    public void add(Student student, Book book) {
        int amountStudents = studentDAO.getStudents().size();
        Queue studentsIdWL = new Queue(amountStudents);
        studentsIdWL.Enqueue(student.getId() + "");
        WaitingList newWaitingList = new WaitingList(book.getId(), studentsIdWL);
        waitingList.add(newWaitingList);
    }
    
    public WaitingList findByIdBook(String idBook){
        for (WaitingList wl : waitingList) {
           if(wl.getIdBook().equalsIgnoreCase(idBook))
               return wl;
        }
        return null;
    }
    
    public void removeFirstStudent(String idBook){
        WaitingList wl = findByIdBook(idBook);
        if(wl != null){
            if(wl.getStudents().size() > 1){        
                wl.getStudents().Dequeue();
            }else{
                waitingList.remove(wl);
            }
        }
    }
    
    public void save() {
        List<String> datas = new ArrayList<>();
        datas.add(WaitingList.HEAD_CSV);
        for (int i = 0; i < waitingList.size(); i++) {
            datas.add(waitingList.get(i).getCSVFormat());
        }
        WriteCSV.writefile(WaitingListDAO.FILE_WAITING_LIST, datas);
    }
    
    
    public int linearSearch(List<WaitingList> array, String target) {
        
        for (int i = 0; i < array.size(); i++) {
            String idBook = array.get(i).getIdBook();
            if (idBook.equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

}
