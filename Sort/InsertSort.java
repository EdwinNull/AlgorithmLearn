public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        insertSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i-1;j >= 0 && arr[j+1] < arr[j]; j--){
                swap(arr, j, j+1);
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
