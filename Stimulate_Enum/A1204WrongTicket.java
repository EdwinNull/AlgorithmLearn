package Stimulate_Enum;

import java.util.*;

//读取数据有难度
public class A1204WrongTicket {
    static int N;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine().trim());//trim()去掉空格
        int[] arr = new int[100010];
        int min = 0,max = 0;
        for(int i=0;i<N;i++){
            //去除字符间空格
            String[] strings = sc.nextLine().split("\\s+");
            for(int j =0;j<strings.length;j++){
                int num = Integer.parseInt(strings[j]);
                min = Math.min(min,num);
                max = Math.max(max,num);
                arr[num]++;
            }
        }
        int m=0,n=0;
        for(int i = min;i<=max;i++){
            if(arr[i]==0) m = i;
            if(arr[i]==2) n = i;
        }
        System.out.printf("%d %d",m,n);
        sc.close();
    }
}
