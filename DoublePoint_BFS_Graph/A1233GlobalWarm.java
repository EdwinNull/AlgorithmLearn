package DoublePoint_BFS_Graph;

import java.util.*;

public class A1233GlobalWarm {
    static int N = 1010,n;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1}; 
    static char[][] map = new char[N][N];
    static boolean[][] vis = new boolean[N][N];

    static class Pair<K,V>{
        K key;
        V value;
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

    public static int[] bfs(int x,int y){
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(x,y));
        vis[x][y] = true;
        int total = 0,bound = 0;
        while(queue.size()>0){
            Pair<Integer,Integer> cur = queue.poll();
            total++;
            boolean is_bound = false;
            for(int i = 0;i<4;i++){
                int cx = cur.getKey()+dx[i];
                int cy = cur.getValue()+dy[i];
                if(cx< 0 || cx>=n || cy<0 || cy>=n || vis[cx][cy]) continue;
                if(map[cx][cy] == '.'){
                    is_bound = true;
                    continue;
                }
                queue.add(new Pair<>(cx,cy));
                vis[cx][cy] = true;
            }
            if(is_bound) bound++;
        }
        return new int[]{total,bound};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0;i<n;i++){
            String str = sc.next();
            map[i] = str.toCharArray();;
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(!vis[i][j] && map[i][j] == '#'){
                    int[] res = bfs(i,j);
                    if(res[0] == res[1]) ans++;
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
