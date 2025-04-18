package DoublePoint_BFS_Graph;

import java.util.*;

public class A1240CompleteBTree {
    static int MAXN = 100000;
    static int n;
    static int[] nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int depth = 0;
        long max=-Integer.MIN_VALUE;
        nodes = new int[n+1];
        for(int i = 1;i<=n;i++){
            nodes[i] = sc.nextInt();
        }
        for(int i = 1,d = 1;i<=n;d++,i*=2){
            long sum = 0;
            for(int j = i;j<i+Math.pow(2,d-1)&&j<=n;j++){
                sum += nodes[j];
            }
            if(sum>max){
                max = sum;
                depth = d;
            }
        }
        System.out.println(depth);
        sc.close();
    }
}
