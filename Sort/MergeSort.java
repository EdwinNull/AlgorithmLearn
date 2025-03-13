public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        sort(arr, 0, arr.length-1);
        for(int i : arr){
            System.out.print(i + " ");
            }
    }
    
    public static void sort(int[] arr, int L, int R){
        if(L==R){
            return;
        }
        int mid  = L + (R-L)/2;
        sort(arr, L, mid);
        sort(arr, mid+1, R);
        process(arr, L, mid, R);
    }

    public static void process(int[] arr, int L, int M, int R) {
        int [] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        while(p1 <= M && p2 <= R){
            help[i++] = arr[p1] <= arr[p2]? arr[p1++] : arr[p2++];
        }
        while(p1 <= M){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }
        for(int j = 0; j < help.length; j++){
            arr[L+j] = help[j];
        }
    }
}
