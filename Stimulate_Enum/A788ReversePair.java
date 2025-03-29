package Stimulate_Enum;

import java.util.Scanner;

public class A788ReversePair {
    static int N = 100010;static int n;
    static long[] nums = new long[N];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(mergeSort(0,n-1));
        sc.close();
    }

    private static long mergeSort(int l, int r) {
        if (l >= r)
            return 0;

        int mid = l + r >> 1;
        long res = 0;
        res += mergeSort(l, mid) + mergeSort(mid + 1, r);

        // 归并排序
        long[] tmp = new long[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j])
                tmp[k++] = nums[i++];
            else {
                tmp[k++] = nums[j++];
                // 情况三
                res += mid - i + 1;
            }
        }

        // 扫尾
        while (i <= mid)
            tmp[k++] = nums[i++];
        while (j <= r)
            tmp[k++] = nums[j++];

        // tmp -> nums
        for (i = l, j = 0; i <= r; i++, j++) {
            nums[i] = tmp[j];
        }
        return res;
    }
}
