package Basis.Vars;

import java.util.Scanner;

public class Media {
	static double aw = 3.5;
	static double bw = 7.5; 
	public static void main(String args[]) {
		Scanner scanner= new Scanner(System.in);
		double A = scanner.nextDouble();
		double B = scanner.nextDouble();
		double res = (A*3.5+B*7.5)/11.0;
		System.out.printf("MEDIA = %.5f",res);
		scanner.close();
	}
}
