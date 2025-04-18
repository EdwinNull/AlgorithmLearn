import java.util.*;

public class Dijstra {
    static int MAXN = 100010;
    static int inf = Integer.MAX_VALUE;
    static int[] dist = new int[MAXN];
    static ArrayList<Pair>[] G = new ArrayList[100];

    static class Pair{
        int first, second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void dijstra(int u){
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a->a.second));
        Arrays.fill(dist,inf);
        dist[u] = 0;
        queue.add(new Pair(u,0));
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            int v = cur.first;
            int curDist = cur.second;
            if(curDist>dist[v]) continue;
            for(Pair e:G[v]){
                int s = e.first;
                int w = e.second;
                if(dist[v]+w<dist[s]){
                    dist[s] = dist[v]+w;
                    queue.add(new Pair(s,dist[s]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0;i<=n;i++) G[i] = new ArrayList<>();
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            G[u].add(new Pair(v,w));
        }
        int s = sc.nextInt();
        dijstra(s);
        for(int i=1;i<=n;i++){
            if(dist[i]==inf) System.out.println("INF");
            else System.out.println(dist[i]);
        }
        sc.close();
    }
}
