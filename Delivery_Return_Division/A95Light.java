package Delivery_Return_Division;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A95Light {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        //存储结果
        List<Integer> results = new ArrayList<>();
        while(T-- > 0){
            int [][] grid = new int[5][5];
            for(int i=0;i<5;i++){
                String line = scanner.next();
                for(int j = 0;j<5;j++){
                    grid[i][j] = line.charAt(j) == '0' ? 0 : 1;
                }
            }
            int result = solve(grid);
            results.add(result<=6?result:-1);
        }
        scanner.close();
        for(int result:results){
            System.out.println(result);
        }
    }

    public static int solve(int[][] grid){
        int minSteps = Integer.MAX_VALUE;
        for(int k=0;k<32;k++){
            int[][] temp = copy(grid);
            int steps = 0;
            //验证第一行操作，提出k的第j位，然后对对应位进行操作
            for(int i=0;i<5;i++){
                if((k>>i & 1)==1){
                    turn(temp,0,i);
                    steps++;
                }
            }
            //处理后续行
            for(int i=1;i<5;i++){
                for(int j=0;j<5;j++){
                    if(temp[i-1][j]==0){
                        turn(temp,i,j);
                        steps++;
                    }
                }
            }
            //检查最后一行是否全为1
            boolean flag = true;
            for(int j = 0;j<5;j++){
                if(temp[4][j]==0){
                    flag = false;
                    break;
                }
            }
            if(flag&&steps<=6){
                minSteps = Math.min(minSteps,steps);
            }
        }
        return minSteps;
    }

    public static void turn(int[][] grid,int i,int j){
        int[] dx = {0,1,-1,0,0};
        int[] dy = {0,0,0,1,-1};
        for(int d = 0;d<5;d++){
            int x = i+dx[d];
            int y = j+dy[d];
            if(x >= 0 && x<5 && y>= 0 && y<5){
                grid[x][y] = 1-grid[x][y];
            }
        }
    }

    public static int[][] copy(int[][] grid){
        int [][] newGrid = new int[5][5];
        for(int i = 0;i<5;i++){
            System.arraycopy(grid[i],0,newGrid[i],0,5);
        }
        return newGrid;
    }
}
