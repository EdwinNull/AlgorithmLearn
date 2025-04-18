// package test;
import java.io.*;
import java.util.*;
import java.math.*;
import java.time.*;

public class Main {
    static final int N = (int) 1e5 + 10;
    static int n;
    static int p[]=new int[N];
    static int find(int x) {
        if(x!=p[x]) p[x]=find(p[x]);
        return p[x];
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ss;
        
        Arrays.setAll(p, i->i);
        n=sc.nextInt();
        int m=sc.nextInt();
        while(m-- > 0) {
            int x=sc.nextInt(),y=sc.nextInt();
            int rx=find(x),ry=find(y);
            p[rx]=ry;
        }
        m=sc.nextInt();
        while(m-- > 0) {
            int x=sc.nextInt(),y=sc.nextInt();
            int rx=find(x),ry=find(y);
            p[rx]=ry;
        }
        //判断祖宗
        int r=find(1);
        for(int i=2;i<=n;++i) {
            if(r!=find(i)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        bw.flush();
    }
}