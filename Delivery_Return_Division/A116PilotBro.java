package Delivery_Return_Division;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A116PilotBro {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = 0;
        for (int i = 0; i < 4; i++) {
            String line = scanner.nextLine().trim();
            for (int j = 0; j < 4; j++) {
                if (line.charAt(j) == '+') {
                    int pos = i * 4 + j;
                    //得到一个仅pos位置为1的数，以此来记录位置信息
                    s |= (1 << pos);
                }
            }
        }

        int[] opMasks = new int[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int mask = 0;
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        if (x == i || y == j) {
                            int pos = x * 4 + y;
                            mask |= (1 << pos);
                        }
                    }
                }
                opMasks[i * 4 + j] = mask;
            }
        }

        int minSteps = Integer.MAX_VALUE;
        int bestMask = 0;

        for (int mask = 0; mask < (1 << 16); mask++) {
            int steps = Integer.bitCount(mask);
            if (steps > minSteps) {
                continue;
            }
            int total = 0;
            for (int k = 0; k < 16; k++) {
                if ((mask & (1 << k)) != 0) {
                    total ^= opMasks[k];
                }
            }
            if (total == s) {
                if (steps < minSteps || (steps == minSteps && mask < bestMask)) {
                    minSteps = steps;
                    bestMask = mask;
                }
            }
        }

        List<int[]> operations = new ArrayList<>();
        for (int k = 0; k < 16; k++) {
            if ((bestMask & (1 << k)) != 0) {
                int i = k / 4 + 1;
                int j = k % 4 + 1;
                operations.add(new int[]{i, j});
            }
        }

        System.out.println(minSteps);
        for (int[] op : operations) {
            System.out.println(op[0] + " " + op[1]);
        }
        scanner.close();
    }
}
