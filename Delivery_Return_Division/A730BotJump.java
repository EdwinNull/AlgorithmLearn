package Delivery_Return_Division;

import java.util.*;

public class A730BotJump {
    static int N;
    static int[] height = new int[100010];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 1;i<=N;i++){
            height[i] = sc.nextInt();
        }
        int l =1,r=100000;
        while(l<r){
            int mid = (l+r)/2;
            if(jump(mid)){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        System.out.println(l);
        sc.close();
    }

    public static boolean jump(int E){
            for(int i =1;i<=N;i++){
                //数学推导出第i处机器人的能量
                E = 2*E-height[i];
                if(E<0) return false;
                if(E>1e5) return true;
            }
            return true;
    } 

}
