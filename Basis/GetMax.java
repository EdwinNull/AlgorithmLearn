
//Iterative

//递归
public class GetMax {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int L = 0;
        int R = arr.length - 1;
        int max = process(arr, L, R);
        System.out.println("Maximum element is " + max);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = (L + (R - L) / 2); // using bitwise operator to get mid index
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}