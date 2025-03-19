package Branch;

import java.util.Scanner;

public class P5715NumberSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[3];
        for(int i=0;i<3;i++){
            arr[i] = sc.nextInt();
        }
        insertSort(arr);
        for(int i=0;i<3;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
