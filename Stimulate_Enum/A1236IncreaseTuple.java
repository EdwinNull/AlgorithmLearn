package Stimulate_Enum;

import java.util.*;

//二分写法：要注意二分的目的
public class A1236IncreaseTuple {
    static int N = 100010;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long res = 0L;
        int A[] = new int[n];
        int B[] = new int[n];
        int C[] = new int[n];
        int as[] = new int[N];
        int cs[] = new int[N];
        int cnt[] = new int[N];
        int s[] = new int[N];
        for(int i = 0;i<n;i++){
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            C[i] = sc.nextInt();
        }
        //二分写法
        // Arrays.sort(A);
        // Arrays.sort(B);
        // Arrays.sort(C);
        // for(int i = 0;i<n;i++){
        //     int index1 = findNum(C,B[i]);
        //     int index2 = findNum2(A,B[i]);
        //     res = res + (long)(1+index2)*(n-index1);
        // }

        //前缀和写法
        for(int i = 0;i<n;i++){
            cnt[A[i]] ++;
        }
        //求前缀和
        for(int i =1;i<N;i++){
            s[i] = s[i-1] + cnt[i];
        }
        for(int i = 0;i<n;i++){
            as[i] = s[B[i]-1];
        }
        Arrays.fill(cnt,0);
        Arrays.fill(s,0);
        for(int i = 0;i<n;i++){
            cnt[C[i]] ++;
        }
        for(int i =1;i<N;i++){
            s[i] = s[i-1] + cnt[i];
        }
        for(int i = 0;i<n;i++){
            cs[i] = s[N-1]-s[B[i]];
        }
        for(int i = 0;i<n;i++){
            res += (long) as[i]*cs[i];
        }
        System.out.println(res);
        sc.close();
    }

    //找到第一个大于m的数的索引
    public static int findNum(int[] arr,int m){
        int n = arr.length;
        int l = 0,r = n-1;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid]>m){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return arr[r] > m ? r:n;
    }
    
    //找到最后一个小于m的数的索引
    public static int findNum2(int[] arr, int m) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (arr[mid] < m) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return arr[l] < m ? l : -1;
    }
}
