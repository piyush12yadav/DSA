package Sorting;

import java.util.Arrays;

public class SelectionSort {
    static void main() {
        int[] arr = {3, 1, 6, -63, 0,4,7};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){
        for (int i=0; i<arr.length; i++){
            int maxIdx = getMax(arr, 0, arr.length-i-1);
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
    static  int getMax(int[] arr , int start , int end ){
        int max = start;
        for (int i=start; i<=end; i++ ){
            if(arr[i]>arr[max]){
                max = i;
            }
        }
        return max;
    }
}
