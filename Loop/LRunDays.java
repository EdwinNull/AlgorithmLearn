package Loop;

public class LRunDays {
    public static void main(String[] args) {
        int sum = 0;
        int days = 6; // 默认周六
        int months[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int i = 0; i < months.length; i++) {
            for (int j = 1; j <= months[i]; j++) {
                if (j == 1 || j == 11 || j == 21 || j == 31 || days == 6 || days == 0)
                    sum++;
                days = ++days % 7;
            }
        }
        System.out.println(sum);
    }
}
