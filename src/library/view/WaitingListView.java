/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.view;

import library.controller.WaitingListController;
import library.model.Book;
import library.model.Student;
import library.model.WaitingList;
import library.utilities.ColorMessage;
import library.utilities.InputUtils;
import library.utilities.Queue;

/**
 *
 * @author Silvia Shimabuko
 */
public class WaitingListView {

    private static final WaitingListController wlc = new WaitingListController();

    /**
     * Add the student to the waiting list (if confirmed) 
     * Do not add in case the students is already in the list
     * @param book
     * @param student 
     */
    public void addWaitingList(Book book, Student student) {
        Queue students = wlc.getWaitingList().get(book.getId());
        
        if (students != null) { //add to the current waiting list
            //check if this student is already included, if so, do not include again
            int position = students.hasElement(String.valueOf(student.getId()));

            if (position >= 0) {
                ColorMessage.print("Student is already in the waiting list. The position is " + (position + 1) + "°", ColorMessage.PINK);
            } else {
                String confirmMessage = "Would you like to add this student in the waiting list? \n"
                        + "This student will be in the " + (students.size() + 1) + "° position\n"
                        + "Type 1 to confirm or 2 to cancel the operation";
                int confirm = InputUtils.getUserIntBetween(confirmMessage, 1, 2, ColorMessage.BLUE);
                if (confirm == 1) {
                    students.Enqueue(student.getId() + "");
                    ColorMessage.print("The student is added to the waiting list", ColorMessage.GREEN);
                    wlc.save();
                } else {
                    ColorMessage.print("Operation Cancelled", ColorMessage.GREEN);
                }
            }
        } else {//add new register to the waiting list
            String confirmMessage = "Would you like to add this student in the waiting list? \n"
                    + "There is no one in the waiting list\n"
                    + "Type 1 to confirm or 2 to cancel the operation";
            int confirm = InputUtils.getUserIntBetween(confirmMessage, 1, 2, ColorMessage.BLUE);
            if (confirm == 1) {
                wlc.add(student, book);
                wlc.save();
                ColorMessage.print("The student is added to the waiting list", ColorMessage.GREEN);
            } else {
                ColorMessage.print("Operation Cancelled", ColorMessage.GREEN);
            }
        }
    }
}
