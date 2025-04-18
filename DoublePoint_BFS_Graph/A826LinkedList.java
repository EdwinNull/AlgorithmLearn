package DoublePoint_BFS_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A826LinkedList{
    static int[] adds;
    static int[] values;
    static int num = 1;
    static int head = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        adds = new int[m + 1];
        values = new int[m + 1];
        while (m-- > 0) {
            String str = br.readLine();
            if (str.charAt(0) == 'H') {
                int x = Integer.parseInt(str.split(" ")[1]);
                head(x);
            } else if (str.charAt(0) == 'D') {
                int k = Integer.parseInt(str.split(" ")[1]);
                delete(k);
            } else if (str.charAt(0) == 'I') {
                int k = Integer.parseInt(str.split(" ")[1]);
                int x = Integer.parseInt(str.split(" ")[2]);
                insert(k, x);
            }
        }

        int item = head;
        while (values[item] != 0) {
            System.out.print(values[item] + " ");
            item = adds[item];
        }
    }

    static void delete(int k) {
        if (k == 0) {
            if (adds[head] == 0) {
                head = 0;
            } else {
                head = adds[head];
            }

        } else {
            if (adds[adds[k]] != 0) {
                adds[k] = adds[adds[k]];
            } else {
                adds[k] = 0;
            }

        }
    }

    static void insert(int k, int x) {
        values[num] = x;
        if (adds[k] != 0) {
            adds[num] = adds[k];
            adds[k] = num;
        } else {
            adds[k] = num;
        }
        num++;
    }

    static void head(int x) {
        values[num] = x;

        if (head == 0) {
            head = num;
        } else {
            adds[num] = head;
            head = num;
        }
        num++;
    }
}
