import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // 确定最大值和最小值
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }
        // 计算桶的数量，这里取数组长度的平方根
        int bucketCount = (int) Math.sqrt(arr.length);
        bucketCount = Math.max(bucketCount, 1); // 至少一个桶
        int range = max - min + 1;
        // 计算每个桶的大小，向上取整
        int bucketSize = (int) Math.ceil((double) range / bucketCount);
        // 初始化桶
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        // 将元素分配到桶中
        for (int num : arr) {
            int bucketIndex = (num - min) / bucketSize;
            buckets.get(bucketIndex).add(num);
        }
        //对每个桶排序并合并到原数组
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket); // 使用库函数排序
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 2, 9, 1, 7, 4, 6, 0 };
        bucketSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
