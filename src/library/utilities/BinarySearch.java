/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.utilities;

import java.util.Comparator;
import java.util.List;

/**
 * This class is used to find the object inside the list
 * This algorithm is faster and only works if the list is sorted in advance
 * @author Silvia Shimabuko
 */
public class BinarySearch {
    /**
     * 
     * @param <T> -> generic class
     * @param list 
     * @param target -> object that needs to be found
     * @param c -> comparator 
     * @return 
     */
    public static <T extends Comparable<T>> int binarySearch(List<T> list, T target, Comparator<? super T> c) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2; //divide the list in two
            int cmp;
            if(c == null){ //if comparator is null, check in compareTo existent in the object
                cmp = list.get(mid).compareTo(target);
            }else{ //use the comparator class that is implemented the criteria of order
                cmp = c.compare(list.get(mid),target);
            }
            
            if (cmp < 0) { //if the mid is smaller then target, check in the second half
                left = mid + 1;
            } else if (cmp > 0) { //if the mid is bigger then target, check in the first half
                right = mid - 1;
            } else {
                return mid; //return the object found
            }
        }
        return -1; //not found
    }
}
