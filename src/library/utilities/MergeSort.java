/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.utilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author 2022443Maria
 */
public class MergeSort {
    /**
     * Divide the list until became only one element  
     * @param <T> generic class
     * @param list the main list with all elements  
     * @param c the class that implement comparator 
     * @return 
     */
    public static <T extends Comparable<T>> List<T> divideMerge(List<T> list, Comparator<? super T> c) {

        if (list.size() > 1) {

            int firstHalfSize = list.size() / 2; //check the first half of the list
            List<T> firstHalf = new ArrayList<T>(list.subList(0, firstHalfSize)); //get the first half from the main list 

            //Recursion
            divideMerge(firstHalf, c);

            List<T> secondHalf = new ArrayList<>(list.subList(firstHalfSize, list.size()));//get the second half 

            //Recursion
            divideMerge(secondHalf, c);

            return mergeSort(firstHalf, secondHalf, list, c);
        }
        return list;

    }
    /**
     * compare the elements and sort it
     * @param <T> generic class
     * @param a first half of the main list 
     * @param b second half of the main list 
     * @param s main list 
     * @param c the class that implement comparator 
     * @return 
     */
    private static <T extends Comparable<T>> List<T> mergeSort(List<T> a, List<T> b, List<T> s, Comparator<? super T> c) {

        int counterA = 0; // index to my list A
        int counterB = 0; // index to my list B
        int counterS = 0; // index to my list C

        while (counterA < a.size() && counterB < b.size()) { //Compare between the list A and B 
            if (c == null) { // use compareTo fromm the generic object <T> 
                if (a.get(counterA).compareTo(b.get(counterB)) < 0) {
                    s.set(counterS, a.get(counterA));
                    counterA++;
                } else {
                    s.set(counterS, b.get(counterB));
                    counterB++;
                }
            } else { // use the compare method from the class that implements comparator 
                if (c.compare(a.get(counterA),(b.get(counterB))) < 0) {
                    s.set(counterS, a.get(counterA));
                    counterA++;
                } else {
                    s.set(counterS, b.get(counterB));
                    counterB++;
                }
            }

            counterS++;
        }
        while (counterA < a.size()) { //Get all elements from list A
            s.set(counterS, a.get(counterA));
            counterA++;
            counterS++;
        }
        while (counterB < b.size()) { //Get all elements from list B
            s.set(counterS, b.get(counterB));
            counterB++;
            counterS++;
        }
        
        return s;

    }
}
    

