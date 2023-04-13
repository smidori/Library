/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.model;

import library.utilities.Queue;

/**
 *
 * @author Silvia Shimabuko
 */
public class WaitingList {
    public static final String HEAD_CSV = "idBook,idStudents\n";
    
    private String idBook;
    private Queue students;

    public WaitingList(String idBook, Queue students) {
        this.idBook = idBook;
        this.students = students;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public Queue getStudents() {
        return students;
    }

    public void setStudents(Queue students) {
        this.students = students;
    }

    
    public String getCSVFormat(){
        StringBuilder sb = new StringBuilder();
        sb.append(idBook+",");
        
        if(!getStudents().isEmpty()){
            Queue queueTemp = getStudents();
            boolean addSeparator = false;
            while(queueTemp.size() > 0){
                if(addSeparator)
                    sb.append("|");
                sb.append(queueTemp.Dequeue());
                addSeparator=true;
            }
        }
        
        sb.append("\n");
        return sb.toString();
    }
    
}