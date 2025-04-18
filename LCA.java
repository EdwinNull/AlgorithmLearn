import java.util.*;
 
public class LCA {
    // 定义树中节点的最大数量
    static final int MAXN = (int) 1e5 + 5;
    // 定义用于倍增法的最高对数
    static final int MAXLOG = 20;
    // 存储树的邻接表表示
    static List<Integer>[] tree = new ArrayList[MAXN];
    // 存储每个节点的深度
    static int[] depth = new int[MAXN];
    // 存储每个节点的父节点信息，用于倍增法
    static int[][] parent = new int[MAXN][MAXLOG];
 
    // 深度优先搜索，初始化每个节点的深度和父节点信息
    static void dfs(int node, int prev) {
        for (int i = 1; i < MAXLOG; i++) {
            parent[node][i] = parent[parent[node][i - 1]][i - 1];
        }
        for (int child : tree[node]) {
            if (child != prev) {
                depth[child] = depth[node] + 1;
                parent[child][0] = node;
                dfs(child, node);
            }
        }
    }
 
    // 计算节点 u 和 v 的最近公共祖先 (LCA)
    static int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        for (int i = MAXLOG - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = parent[u][i];
            }
        }
        if (u == v)
            return u;
        for (int i = MAXLOG - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }
        return parent[u][0];
    }
 
    // 主函数，读取输入并调用相关函数计算 LCA
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < MAXN; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }
        // 显式设置根节点的父节点
        parent[1][0] = 1;
        dfs(1, -1);
        int Q = sc.nextInt();
        while (Q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(lca(a, b));
        }
        sc.close();
    }
}