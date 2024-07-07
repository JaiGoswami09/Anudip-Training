package patternLoops;

import java.util.Scanner;

public class SquareHollowPattern {

	public static void main(String[] args) {
		int i;
		int j;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = scn.nextInt();
		
		for (i=1; i<=number; i++) {
			for (j=1; j<=number; j++) {
				if(i==1 || j==1) {
					System.out.print("*");
				}else {
					//System.out.print(" ");
				}
				System.out.println();
		}
	}
	}
}

