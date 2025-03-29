package Stimulate_Enum;

import java.util.*;

public class A1229DateProblem {
    static int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.useDelimiter("\\D+").nextInt();
        }
        Set<String> resultSet = new TreeSet<>();
        String[] result = generate(arr);
        for (String s : result) {
            if (s != null) {
                resultSet.add(s);
            }
        }
        for (String date : resultSet) {
            System.out.println(date);
        }
        sc.close();
    }

    public static String[] generate(int[] arr) {
        String[] result = new String[3];
        if (judge1(arr)) {
            result[0] = formatDate(arr[0], arr[1], arr[2]);
        }
        if (judge2(arr)) {
            result[1] = formatDate(arr[2], arr[0], arr[1]);
        }
        if (judge3(arr)) {
            result[2] = formatDate(arr[2], arr[1], arr[0]);
        }
        return result;
    }

    private static String formatDate(int yearPart, int month, int day) {
        StringBuilder sb = new StringBuilder();
        if (yearPart >= 60) {
            sb.append("19");
        } else {
            sb.append("20");
        }
        sb.append(String.format("%02d", yearPart)).append("-");
        sb.append(String.format("%02d", month)).append("-");
        sb.append(String.format("%02d", day));
        return sb.toString();
    }

    public static boolean isLeapYear(int year) {
        if (year < 60)
            year += 2000;
        else
            year += 1900;
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean judge1(int[] arr) {
        int yearPart = arr[0];
        int month = arr[1];
        int day = arr[2];
        if (month < 1 || month > 12)
            return false;
        int maxDay = days[month - 1];
        if (month == 2 && isLeapYear(yearPart))
            maxDay = 29;
        return day >= 1 && day <= maxDay;
    }

    public static boolean judge2(int[] arr) {
        int yearPart = arr[2];
        int month = arr[0];
        int day = arr[1];
        if (month < 1 || month > 12)
            return false;
        int maxDay = days[month - 1];
        if (month == 2 && isLeapYear(yearPart))
            maxDay = 29;
        return day >= 1 && day <= maxDay;
    }

    public static boolean judge3(int[] arr) {
        int yearPart = arr[2];
        int month = arr[1];
        int day = arr[0];
        if (month < 1 || month > 12)
            return false;
        int maxDay = days[month - 1];
        if (month == 2 && isLeapYear(yearPart))
            maxDay = 29;
        return day >= 1 && day <= maxDay;
    }
}