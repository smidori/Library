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
/*
    public static <T> int binarySearch(T[] arr, T target, Comparator<? super T> c) {
        return binarySearch(arr, target, c, 0, arr.length - 1);
    }
        
    private static <T> int binarySearch(T[] arr, T target, Comparator<? super T> c, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = c.compare(target, arr[mid]);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
        */
    /*
     public static <T extends Comparable<T>> int binarySearch(List<T> list, T target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = list.get(mid).compareTo(target);
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
    */
}
