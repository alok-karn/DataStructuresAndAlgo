package sorting;



public class quickSort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; // store the element at index i in temp
        arr[i] = arr[j]; // store the element at index j in index i
        arr[j] = temp; // store the element at index i in index j
    }

    static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high); // pivot is the index of the element which is at its correct position
            QuickSort(arr, low, pivot - 1); // sort the left subarray
            QuickSort(arr, pivot + 1, high); // sort the right subarray
        }


    }
    

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot is the last element of the array
        int i = low - 1; // i is the index of the smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // if the current element is smaller than the pivot
                i++; // increment the index of the smaller element
                swap(arr, i, j); // swap the elements at i and j
            }
        }
        swap(arr, i + 1, high); // swap the pivot with the element at i+1
        return i + 1; // return the index of the pivot
    }




    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        QuickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    
}
