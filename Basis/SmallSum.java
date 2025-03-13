package Basis;

public class SmallSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        int n = arr.length;
        int sum = process(arr,0,n-1);
        System.out.println("Sum of the array is: " + sum);
    }

    public static int process(int[] arr, int l, int r){
        if(l == r){
            return 0;
        }
        int mid = l + (r-l)/2;
        return process(arr,mid+1,r) + process(arr,l,mid) + merge(arr,l,mid,r);
    }

    public static int merge(int[] arr, int L, int M, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2]? (R-p2+1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return res;
    }
}
