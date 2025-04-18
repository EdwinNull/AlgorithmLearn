package DoublePoint_BFS_Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A1113BlackAndRed {
    static int MAXN = 401;
    static int W,H;
    static int[] dx = {-1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static char[][] map = new char[MAXN][MAXN];
    static boolean[][] vis = new boolean[MAXN][MAXN];
    
    static class Pair<K,V>{
        K key;
        V value;
        public Pair(K key,V value){
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

    public static int bfs(int x,int y){
        int cnt = 1;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<Integer,Integer>(x,y));
        while(queue.size()>0){
            Pair<Integer,Integer> cur = queue.poll();
            for(int i =0;i<4;i++){
                int nx = cur.getKey()+dx[i];
                int ny = cur.getValue()+dy[i];
                if(nx<0 || nx>=H || ny<0 || ny>=W) continue;
                if(vis[nx][ny]) continue;
                if(map[nx][ny] != '.') continue;
                vis[nx][ny] = true;
                queue.add(new Pair<Integer,Integer>(nx, ny));
                cnt ++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            W = sc.nextInt();
            H = sc.nextInt();
            if(W == 0 || H == 0) break;
            for(int i = 0;i<H;i++){
                map[i] = sc.next().toCharArray();
            }
            Pair<Integer,Integer> start=null;
            for(int i=0;i<H;i++){
                for(int j = 0;j<W;j++){
                    if(map[i][j] == '@') start = new Pair<Integer,Integer>(i,j);
                }
            }
            int ans = bfs(start.getKey(),start.getValue());
            for(int i=0;i<H;i++){
                Arrays.fill(vis[i],false);
            }
            System.out.println(ans);
        }
        sc.close();
    }   
}
