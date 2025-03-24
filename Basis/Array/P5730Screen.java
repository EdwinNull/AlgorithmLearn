package Array;

import java.util.Scanner;

public class P5730Screen {
    public static void main(String[] args) {
        int [] arr = new int[101];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        display(n,arr);
        sc.close();
    }
    public static void display(int n, int[] arr){
        char[][][] number = {
            {
                {'X','X','X'},
		        {'X','.','X'},
		        {'X','.','X'},
		        {'X','.','X'},
		        {'X','X','X'},
            },
            {
                {'.','.','X'},
                {'.','.','X'},
                {'.','.','X'},
                {'.','.','X'},
                {'.','.','X'},
            },
                { // 2
                        {'X', 'X', 'X'},
                        {'.', '.', 'X'},
                        {'X', 'X', 'X'},
                        {'X', '.', '.'},
                        {'X', 'X', 'X'},
                },
                { // 3
                        {'X', 'X', 'X'},
                        {'.', '.', 'X'},
                        {'X', 'X', 'X'},
                        {'.', '.', 'X'},
                        {'X', 'X', 'X'},
                },
                { // 4
                        {'X', '.', 'X'},
                        {'X', '.', 'X'},
                        {'X', 'X', 'X'},
                        {'.', '.', 'X'},
                        {'.', '.', 'X'},
                },
                { // 5
                        {'X', 'X', 'X'},
                        {'X', '.', '.'},
                        {'X', 'X', 'X'},
                        {'.', '.', 'X'},
                        {'X', 'X', 'X'},
                },
                { // 6
                        {'X', 'X', 'X'},
                        {'X', '.', '.'},
                        {'X', 'X', 'X'},
                        {'X', '.', 'X'},
                        {'X', 'X', 'X'},
                },
                { // 7
                        {'X', 'X', 'X'},
                        {'.', '.', 'X'},
                        {'.', '.', 'X'},
                        {'.', '.', 'X'},
                        {'.', '.', 'X'},
                },
                { // 8
                        {'X', 'X', 'X'},
                        {'X', '.', 'X'},
                        {'X', 'X', 'X'},
                        {'X', '.', 'X'},
                        {'X', 'X', 'X'},
                },
                { // 9
                        {'X', 'X', 'X'},
                        {'X', '.', 'X'},
                        {'X', 'X', 'X'},
                        {'.', '.', 'X'},
                        {'X', 'X', 'X'},
                }
        };
        for(int i = 0;i<5;i++){
            for(int j = 0;j<n;j++){
                for(int k = 0;k<3;k++){
                    System.out.print(number[arr[j]][i][k]);
                }
                if(j!=n-1){
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}

