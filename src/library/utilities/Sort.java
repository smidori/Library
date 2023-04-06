/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.utilities;

/**
 *
 * @author 35385
 */
public class Sort {
    
    public int[] insertionSort(int[] array) {        
        System.out.println("-----------");
        System.out.println("--Insertion Sort starting--");

        for(int i=1; i<array.length;i++){
            int keyElement=array[i];
            int pos = i;
            //printArray(array);
            
            while(pos>0 && array[pos - 1] > keyElement){
                array[pos] = array[pos -1];
                pos=pos-1;                               
            }
            array[pos] = keyElement;
        }
        
        System.out.println("--Array Sorted--");
        System.out.println("-----------");
        return array;
    }
    
    public int[] bubbleSortDW (int[] array){
        System.out.println("-----------");
        int temp;
        boolean swap = false;        
        do{
            swap=false;
            //printArray(array);
            for(int j=0; j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    swap=true;
                }                
            }            
        }while(swap);
        System.out.println("-----------");
        return array;        
    }
    
}
