package Basis.Vars;

import java.util.Scanner;

public class A610Bonus {

	@SuppressWarnings("unused")
    public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		double basis,bonus;
		basis=scanner.nextDouble();bonus=scanner.nextDouble();
		System.out.printf("TOTAL = R$ %.2f", basis+bonus*0.15);
		scanner.close();
	}
}
