package DoublePoint_BFS_Graph;

import java.util.*;


public class A1096UnderMaster {
    static int MAXN = 110;
    static int L,R,C;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static char[][][]map;
    static int[][][]visited = new int[MAXN][MAXN][MAXN];

    static class Triple<K,V,T>{
        K key;
        V value;
        T third;
        public Triple(K key,V value,T third){
            this.key = key;
            this.value = value;
            this.third = third;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
        public T getThird(){
            return third;
        }
    }

    public static int bfs(Triple<Integer,Integer,Integer> start,Triple<Integer,Integer,Integer> end){
        Queue<Triple<Integer,Integer,Integer>> queue = new LinkedList<>();
        for(int i = 0;i<MAXN;i++){
            for(int j = 0;j<MAXN;j++){
                Arrays.fill(visited[i][j],-1);
            }
        }
        visited[start.getKey()][start.getValue()][start.getThird()] = 0;
        queue.add(start);
        while(queue.size()>0){
            Triple<Integer,Integer,Integer> cur = queue.poll();
            for(int i =0;i<6;i++){
                int x = cur.getKey() + dx[i];
                int y = cur.getValue() + dy[i];
                int z = cur.getThird()+dz[i];
                if(x<0 || x>=L || y<0 || y>=R || z<0 || z>=C || visited[x][y][z]!=-1) continue;
                if(map[x][y][z] == '#') continue;
                visited[x][y][z] = visited[cur.getKey()][cur.getValue()][cur.getThird()]+1;
                if(x==end.getKey() && y==end.getValue() && z==end.getThird()){
                    return visited[x][y][z];
                }
                queue.add(new Triple<>(x,y,z));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            if(L==0&&R==0&&C==0) break;
            Triple<Integer, Integer, Integer> start = null, end = null;
            map = new char[MAXN][MAXN][MAXN];
            for(int i = 0;i<L;i++){
                for(int j = 0;j<R;j++){
                    String str = sc.next();
                    map[i][j] = str.toCharArray();
                    for (int k = 0; k < C; k++) {
                        if (map[i][j][k] == 'S') {
                            start = new Triple<>(i, j, k);
                        }
                        if (map[i][j][k] == 'E') {
                            end = new Triple<>(i, j, k);
                        }
                    }
                }
            }
            int distance = bfs(start,end);
            if(distance == -1) System.out.println("Trapped!");
            else{
                System.out.printf("Escaped in %d minute(s).\n",distance);
            }
        }
        sc.close();
    }
}
