public class FastSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 3, 9, 1, 7, 4, 6 };
        fastSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 选择最右边的元素作为基准
        int i = left - 1; // i是小于基准的元素的最后一个索引
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                // 交换arr[i]和arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 交换arr[i+1]和arr[right] (或pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1; // 返回基准的新位置
    }


    public static void fastSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right); // 获取基准的位置
            fastSort(arr, left, pivotIndex - 1); // 对基准左边的部分进行排序
            fastSort(arr, pivotIndex + 1, right); // 对基准右边的部分进行排序
        }
    }
}