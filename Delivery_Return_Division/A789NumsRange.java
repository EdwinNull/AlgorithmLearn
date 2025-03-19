package Delivery_Return_Division;

import java.util.Scanner;

public class A789NumsRange {
    static int n,q;
    static int[] nums = new int[100010];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        for(int i=0;i<q;i++){
            int x = sc.nextInt();
            int l = 0,r = n-1;
            while(l<r){
                int mid = (l+r)>>1;
                if(nums[mid] >= x){
                    r = mid;
                }
                else{
                    l = mid+1;
                }
            }
            //欲求目标数字的起始位置，需要先找最左边数字，再找最右边数字
            if(nums[r] == x){
                System.out.printf("%d ",r);
                l = 0;
                r = n-1;
                while(l<r){
                    int mid = (l+r+1) >> 1;
                    if(nums[mid]<=x) l = mid;
                    else r = mid-1;
                }
                System.out.println(r);
            }
            else{
                System.out.println("-1 -1");
            }
        }
        sc.close();
    }
}
