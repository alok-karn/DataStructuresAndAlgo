package sorting;

public class mergeSort {

    static void MergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2; // find the middle index
            MergeSort(arr, low, mid); // sort the left subarray
            MergeSort(arr, mid + 1, high); // sort the right subarray
            merge(arr, low, mid, high); // merge the two sorted subarrays
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[arr.length];
        for (int i = left; i <= right; i++) {
            tempArr[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (tempArr[i] <= tempArr[j]) {
                arr[k] = tempArr[i];
                i++;
            } else {
                arr[k] = tempArr[j];
                j++;
            }
        }
        k++;
        while (i <= mid) {
            arr[k] = tempArr[i];
            i++;
            k++;
        }
    }


    
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        MergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
