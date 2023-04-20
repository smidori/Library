/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.utilities;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Silvia Shimabuko
 */
public class BinarySearch {
 
    public static <T extends Comparable<T>> int binarySearch(List<T> list, T target, Comparator<? super T> c) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp;
            if(c == null){
                cmp = list.get(mid).compareTo(target);
            }else{
                cmp = c.compare(list.get(mid),target);
            }
            
            if (cmp < 0) {
                left = mid + 1;
            } else if (cmp > 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
