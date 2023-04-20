/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.controller;

import java.util.List;
import library.model.Book;
import library.model.Student;
import library.model.WaitingList;
import library.model.dao.WaitingListDAO;

/**
 *
 * @author Silvia Shimabuko
 */
public class WaitingListController {
    
    WaitingListDAO dao = new WaitingListDAO();
    
    public void loadDataWaitingList(){
        dao.loadDataWaitingList();
    }
    
    public int linearSearch(List<WaitingList> array, String target) {
        return dao.linearSearch(array, target);
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
    
    public List<WaitingList> getWaitingList() {
        return dao.getWaitingList();
    }
    
    
}
