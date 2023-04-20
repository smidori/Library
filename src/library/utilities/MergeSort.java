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
    
    public static <T extends Comparable<T>> List<T> divideMerge(List<T> list, Comparator<? super T> c) {

        if (list.size() > 1) {

            int firstHalfSize = list.size() / 2;
            List<T> firstHalf = new ArrayList<T>(list.subList(0, firstHalfSize));

            //Recursion
            divideMerge(firstHalf, c);

            List<T> secondHalf = new ArrayList<>(list.subList(firstHalfSize, list.size()));

            //Recursion
            divideMerge(secondHalf, c);

            return mergeSort(firstHalf, secondHalf, list, c);
        }
        return list;

    }

    private static <T extends Comparable<T>> List<T> mergeSort(List<T> a, List<T> b, List<T> s, Comparator<? super T> c) {

        int counterA = 0;
        int counterB = 0;
        int counterS = 0;

        while (counterA < a.size() && counterB < b.size()) {
            if (c == null) {
                if (a.get(counterA).compareTo(b.get(counterB)) < 0) {
                    s.set(counterS, a.get(counterA));
                    counterA++;
                } else {
                    s.set(counterS, b.get(counterB));
                    counterB++;
                }
            } else {
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
        while (counterA < a.size()) {
            s.set(counterS, a.get(counterA));
            counterA++;
            counterS++;
        }
        while (counterB < b.size()) {
            s.set(counterS, b.get(counterB));
            counterB++;
            counterS++;
        }
        
        return s;

    }
}
    

