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

/**
 *
 * @author Silvia Shimabuko
 */
public class WaitingListView {

    private static final WaitingListController wlc = new WaitingListController();

    public void addWaitingList(Book book, Student student) {
        int indexWL = wlc.linearSearch(wlc.getWaitingList(), book.getId());

        if (indexWL >= 0) { //add to the current waiting list
            WaitingList wl = wlc.getWaitingList().get(indexWL);

            //check if this student is already included, if so, do not include again
            int position = wl.getStudents().hasElement(String.valueOf(student.getId()));

            if (position >= 0) {
                ColorMessage.print("Student is already in the waiting list. The position is " + (position + 1) + "°", ColorMessage.PINK);
            } else {
                String confirmMessage = "Would you like to add this student in the waiting list? \n"
                        + "This student will be in the " + (wl.getStudents().size() + 1) + "° position\n"
                        + "Type 1 to confirm or 2 to cancel the operation";
                int confirm = InputUtils.getUserIntBetween(confirmMessage, 1, 2, ColorMessage.BLUE);
                if (confirm == 1) {
                    wl.getStudents().Enqueue(student.getId() + "");
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
