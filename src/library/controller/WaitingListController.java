/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.controller;

import java.util.ArrayList;
import java.util.List;
import library.model.WaitingList;
import library.utilities.Queue;
import library.utilities.ReadCSV;

/**
 *
 * @author Silvia Shimabuko
 */
public class WaitingListController {
    public static final String FILE_WAITING_LIST = "WAITING_LIST_DATA.csv";

    public List<WaitingList> loadDataWaitingList() {
        List<WaitingList> waitinglist = new ArrayList<>();
        ReadCSV reader = new ReadCSV();

        List<String> lines = reader.readFile(FILE_WAITING_LIST);

        if (lines != null) {
            for (String line : lines) {
                String[] data = line.split(",",-1);
                String[] idStudentsStr = data[1].split("\\|");
                Queue idStudents = new Queue();
                for(int i =0; i < idStudentsStr.length; i++){
                    idStudents.Enqueue(idStudentsStr[i]);
                }
                
                WaitingList wl = new WaitingList(data[0], idStudents);
                waitinglist.add(wl);
            }
        }

        return waitinglist;
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
