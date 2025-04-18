package DoublePoint_BFS_Graph;

import java.util.*;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
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

public class A1238Log {
    static int MAXN = 1000010;
    static int N, D, K;
    static List<Pair<Integer, Integer>> logs = new ArrayList<>();
    static int[] cnt = new int[MAXN];
    static boolean[] is = new boolean[MAXN];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = sc.nextInt();
        K = sc.nextInt(); // 读取K

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            logs.add(new Pair<>(x, y));
        }

        logs.sort(Comparator.comparing(Pair::getKey));

        for (int i = 0, j = 0; i < N; i++) {
            int id = logs.get(i).getValue();
            cnt[id]++;

            while (logs.get(i).getKey() - logs.get(j).getKey() >= D) {
                cnt[logs.get(j).getValue()]--;
                j++;
            }

            if (cnt[id] >= K) {
                is[id] = true;
            }
        }

        // 输出所有有效ID
        for (int i = 0; i < MAXN; i++) {
            if (is[i]) {
                System.out.println(i);
            }
        }
        sc.close();
    }
}