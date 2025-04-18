package DoublePoint_BFS_Graph;

import java.util.*;

public class A1101MazeFlower {
    static int MAXN = 210;
    static int T,R,C;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] map;
    static int[][] dis = new int[MAXN][MAXN];

    static class Pair<K,V>{
        private K key;
        private V value;
        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }

    public static int bfs(Pair<Integer, Integer> start, Pair<Integer, Integer> end) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for(int i = 0;i<MAXN;i++){
            Arrays.fill(dis[i],-1);
        }
        dis[start.getKey()][start.getValue()] = 0;
        queue.add(start);
        while (queue.size() > 0) {
            Pair<Integer, Integer> cur = queue.poll();
            if(cur.getKey() == end.getKey() && 
            cur.getValue() == end.getValue()) return dis[end.getKey()][end.getValue()];
            for(int i=0;i<4;i++){
                int x = cur.getKey() + dx[i];
                int y = cur.getValue()+dy[i];
                if(x<0 || x>=R || y<0 || y>=C) continue;
                if(map[x][y]=='#') continue;
                if(dis[x][y]!=-1) continue;

                dis[x][y] = dis[cur.getKey()][cur.getValue()] + 1;
                if(x==end.getKey() && y==end.getValue()) return dis[x][y];
                queue.add(new Pair<>(x,y));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int t = 1;t<=T;t++){
            R = sc.nextInt();
            C = sc.nextInt();
            map = new char[R+1][C+1];
            for(int i = 0;i<R;i++){
                String str = sc.next();
                map[i] = str.toCharArray();
            }
            Pair<Integer,Integer> start = null;
            Pair<Integer,Integer> end = null;
            for(int i = 0;i<R;i++){
                for(int j = 0;j<C;j++){
                    if(map[i][j]=='S') start = new Pair<>(i,j);
                    else if(map[i][j]=='E') end = new Pair<>(i,j);
                }
            }
            int distance = bfs(start,end);
            if(distance==-1){
                System.out.println("oop!");
            }
            else{
                System.out.println(distance);
            }
        }
        sc.close();
    }
}
