package DoublePoint_BFS_Graph;

import java.util.*;

public class A1207Fee{
    static int N = 100010,M = 200010;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int[] w = new int[M];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int idx = 0;
    public static void add(int a,int b,int c)
    {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    public static void bfs(int u)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        Arrays.fill(st, false);
        q.add(u);
        dist[u] = 0;
        st[u] = true;
        while(!q.isEmpty())
        {
            int t = q.poll();
            for(int i = h[t];i != -1;i = ne[i])
            {
                int j = e[i];
                if(st[j]) continue;
                dist[j] = dist[t] + w[i];
                st[j] = true;
                q.add(j);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Arrays.fill(h,-1);
        for(int i = 0;i < n - 1;i ++)
        {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            add(a,b,c);
            add(b,a,c);
        }
        bfs(2);
        int u = 1;
        for(int i = 2;i <= n;i ++)
            if(dist[i] > dist[u])
                u = i;
        bfs(u);
        int maxv = dist[1];
        for(int i = 2;i <= n;i ++)
        {
            if(dist[i] > maxv)
                maxv = dist[i];
        }
        System.out.println(maxv * 10 + ((long)(maxv + 1) * maxv ) / 2);
        scan.close();
    }
}
