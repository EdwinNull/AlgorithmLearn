public class SelectSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return ;
        }
        for(int i = 0;i < arr.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j < arr.length;j++){
                minIndex = arr[j] < arr[minIndex]? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        }

    public static void main(String[] args) {
        int[] arr = {5,2,8,3,9,1,7};
        selectionSort(arr);
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}