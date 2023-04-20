/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.controller;

import java.util.List;
import java.util.Map;
import library.model.Book;
import library.model.Student;
import library.model.dao.WaitingListDAO;
import library.utilities.Queue;

/**
 *
 * @author Silvia Shimabuko
 */
public class WaitingListController {
    
    WaitingListDAO dao = new WaitingListDAO();
    
    public void loadDataWaitingList(){
        dao.loadDataWaitingList();
    }
    
    public void add(Student student, Book book) {
        dao.add(student, book);
    }
    
    public void removeFirstStudent(String idBook){
        dao.removeFirstStudent(idBook);
    }
    
    public void save() {
        dao.save();
    }
    
    public List<Student> findStudentsWaitingListbyIdBook(String idBook) {
        return dao.findStudentsWaitingListbyIdBook(idBook);
    }
    
    public Map<String, Queue> getWaitingList() {
        return dao.getWaitingList();
    }
    
    
}
