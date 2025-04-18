import java.util.*;

public class A1264DynamicRange {
    static int N;
    static long[] A, B;
    static int[] compressed;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        A = new long[N];
        B = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextLong();
        }

        // 离散化处理B数组
        Set<Long> set = new HashSet<>();
        for (long num : B)
            set.add(num);
        List<Long> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        compressed = new int[N];
        for (int i = 0; i < N; i++) {
            compressed[i] = Collections.binarySearch(sorted, B[i]) + 1; // +1 让索引从1开始
        }

        Arrays.sort(A);

        FenwickTree ft = new FenwickTree(sorted.size() + 2);
        long sum = 0;
        for (int i = 0; i < N; i++) {
            ft.update(compressed[i], 1);
            // 找到A[i]在sorted中的位置
            int idx = Collections.binarySearch(sorted, A[i]);
            if (idx < 0)
                idx = -idx - 1;
            else
                idx += 1;
            sum += ft.query(idx - 1);
        }
        System.out.println(sum);
        scanner.close();
    }

    static class FenwickTree {
        int[] tree;
        int size;

        public FenwickTree(int size) {
            this.size = size;
            tree = new int[size + 1];
        }

        public void update(int index, int delta) {
            while (index <= size) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public int query(int index) {
            int res = 0;
            while (index > 0) {
                res += tree[index];
                index -= index & -index;
            }
            return res;
        }
    }
}