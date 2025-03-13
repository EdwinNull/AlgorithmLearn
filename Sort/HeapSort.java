public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. 构建最大堆（从最后一个非叶子节点开始调整）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2. 排序阶段：逐个提取堆顶元素
        for (int i = n - 1; i > 0; i--) {
            // 交换堆顶和当前末尾元素
            swap(arr, 0, i);
            // 调整剩余元素为最大堆（堆大小减1）
            heapify(arr, i, 0);
        }
    }

    // 调整以节点i为根的子树，使其满足最大堆性质
    private static void heapify(int[] arr, int heapSize, int i) {
        int largest = i; // 初始化当前节点为最大值
        int left = 2 * i + 1; // 左子节点索引
        int right = 2 * i + 2; // 右子节点索引

        // 比较左子节点与当前最大值
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        // 比较右子节点与当前最大值
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值不是当前节点，则交换并递归调整
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, heapSize, largest); // 递归调整受影响的子树
        }
    }

    // 交换数组中的两个元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        heapSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
