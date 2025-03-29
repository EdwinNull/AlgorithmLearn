package Stimulate_Enum;

import java.util.*;

public class A1241DeliveryStore {
    static int N,M,T;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int T = sc.nextInt();
        int N = 100010;
        int score[] = new int[N];
        int last[] = new int[N];
        boolean st[] = new boolean[N];
        Node order[] = new Node[N];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            order[i] = new Node(a, b);
        }
        Arrays.sort(order, 0, m);
        for (int i = 0; i < m; i++) {
            int j = i;
            while (j < m && order[j].equals(order[i]))
            j++;
            int id = order[i].y, t = order[i].x, cnt = j - i;
            i = j - 1;
            score[id] -= t - last[id] - 1;
            if (score[id] < 0)
                score[id] = 0;
            if (score[id] <= 3)
                st[id] = false;
            score[id] += cnt * 2;
            if (score[id] > 5)
                st[id] = true;
            last[id] = t;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (last[i] < T) {
                score[i] -= T - last[i];
                if (score[i] <= 3)
                    st[i] = false;
            }
            if (st[i])
                res++;
        }
        System.out.println(res);
        sc.close();
    }

    //Comparable接口保证能被排序
    static class Node implements Comparable<Node> {
        int x, y;

        //初始化
        Node(int a, int b) {
            x = a;
            y = b;
        }

        //排序方法，若x相同则比较y
        public int compareTo(Node o1) {
            if (this.x == o1.x)
                return this.y - o1.y;
            return this.x - o1.x;
        }

        public boolean equals(Node o1) {
            return x == o1.x && y == o1.y;
        }
    }
}
