package Sorting;
import java.util.*;

public class BubbleSort {
    static void main() {

        int[] arr = {13, 46, 24,52,20,9};

        bubbleSort(arr);

    }
   static void bubbleSort(int[] arr){
        int didSwap = 0;

        int n = arr.length;
        for (int i=n-1; i>=0; i--){
            for (int j=0; j<=i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = 1;
                }
            }

            if (didSwap == 0){
                break;
            }
        }

        for (int ele: arr){
            System.out.println(ele + " ");
        }
    }
}
