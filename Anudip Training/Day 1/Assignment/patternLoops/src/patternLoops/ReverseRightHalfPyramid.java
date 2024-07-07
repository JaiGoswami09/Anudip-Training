package patternLoops;

import java.util.Scanner;

public class ReverseRightHalfPyramid {

	public static void main(String[] args) {
		int i;
		int j;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = scn.nextInt();
		
		for (i=1; i<=number; i++) {
			for(j=i; j<=number; j++) {
				System.out.print("* ");
			}
			System.out.println();
		} 
	}

}
