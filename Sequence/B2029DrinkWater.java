package Sequence;

import java.util.Scanner;

public class B2029DrinkWater {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int h = scanner.nextInt();
		int r = scanner.nextInt();
		double volume = 3.14*r*r*h*0.001;
		int n = 1;
		while(n*volume<20) {
			n++;
		}
		System.out.println(n);
		scanner.close();
	}
}
