import java.util.Random;

import static oracle.jrockit.jfr.events.Bits.swap;

public class KthLargest {
    public static void main(String[] args) {
        int arr[] = new int[]{12, 3, 5, 7, 4, 19, 26};
        int k = 6;
        System.out.print(findKthLargest(arr, 0, arr.length - 1, k, arr.length));


    }

    public static int partition(int[] s, int p, int q){
        int pivot = s[q];
        int r = p;
        for (int i = p; i < q; i++){ // dont include pivot
            if (s[i] < pivot){
                int temp = s[i];
                s[i] = s[r];
                s[r] = temp;
                r++;
            }
        }
        int temp = s[q];
        s[q] = s[r];
        s[r] = temp;

        return r; // return position of pivot, always going to be in right place
    }

    public static int findKthLargest(int[] s, int p, int q, int k, int size){
        int pivotIndex = partition(s, p, q); // get position of pivot

        if (pivotIndex  == size - k){ // since pivot is always in right place, if pivotIndex and k are same, pivotIndex is kth
            return s[pivotIndex];       // using size - k instead because this is actually finding kth Smallest if just k. In array of size 10, 3rd smallest = 7th largest
        }

        if (pivotIndex > size - k){ // k -1 for correct position normally but that's rolled into this
            return findKthLargest(s, p, pivotIndex -1, k, size);
        }

        return (findKthLargest(s, pivotIndex + 1, q, k, size));
    }
}
