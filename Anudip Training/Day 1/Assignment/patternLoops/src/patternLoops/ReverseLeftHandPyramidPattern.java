package patternLoops;

import java.util.Scanner;

public class ReverseLeftHandPyramidPattern {

	public static void main(String[] args) {
		int i;
		int j;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = scn.nextInt();
		
		for (i=1; i<=number; i++) {
			for(j=1; j<=i; j++) {
				System.out.print(" ");
			}
			for (j=i; j<=number; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	} 
}