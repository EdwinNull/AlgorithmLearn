package Sequence;
import java.util.Scanner;

public class B2005Triangle {
	public static void main(String args[]) {
		try (Scanner sc = new Scanner(System.in)) {
			String input = sc.next();
			char ch = input.charAt(0);
			System.out.println("  "+ ch);
			System.out.println(" "+ch+ch+ch);
			System.out.println(""+ch+ch+ch+ch+ch);
		}
	}
}
