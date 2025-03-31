package Basis.Vars;

import java.util.Scanner;

public class PointsDistance {

	public static void main(String args[]) {
		double x1,y1,x2,y2;
		Scanner scanner = new Scanner(System.in);
		x1 = scanner.nextDouble();y1 = scanner.nextDouble();
		x2 = scanner.nextDouble();y2 = scanner.nextDouble();
		double dis = Math.sqrt(Math.abs(x2-x1)*Math.abs(x2-x1)+Math.abs(y2-y1)*Math.abs(y2-y1));
		System.out.printf("%.4f",dis);
		scanner.close();
	}
}
