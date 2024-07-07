package patternLoops;

public class Test {

	public static void main(String[] args) {
		int i,j;
		 for(i = 1; i<=5; i++ )// i = 2
		   {
		      for(j= 1; j<=i; j++) 
		      {
		          System.out.print("* ");
		      }
		       System.out.println();
		   }
		//*
		//* *
		//* * *
		//* * * *
		//* * * * *

		 
		 System.out.println();
		 System.out.println();

//		        int i,j;
		        for(i = 5; i>=1; i-- )
		        {
		            for(j= 1; j<=i; j++)
		            {
		                System.out.print("* ");
		            }
		            System.out.println();
		        }
		        
		        System.out.println();
				 System.out.println();
        

		//* * * * *
		//* * * *
		//* * *
		//* *
		//*
				 
				 System.out.println();
				 System.out.println();


//		        int i,j;
		        for (i = 5; i >= 1; i--) {
		            for (j = 1; j < i; j++) {
		                System.out.print(" ");
		            }
		            for (j = 0; j <= 5 - i; j++) {
		                System.out.print("*");
		            }

		            System.out.println();
		        }
		        
		        System.out.println();
				 System.out.println();


//		    *
		//   **
		//  *
		// **
		//***


//		        int i, j;

		        for (i = 5; i >= 1; i--) {
		            for (j = 1; j <= 5 - i; j++) {
		                System.out.print(" ");
		            }
		            for (j = 1; j <= i; j++) {
		                System.out.print("*");
		            }
		            System.out.println();
		        }
		        
		        System.out.println();
				 System.out.println();

		//***
		// **
		//  *
		//   **
//		    *

		//


		        for (i = 1; i <= 5; i++) {
		            for (j = 1; j <= 5; j++) {
		                System.out.print("* ");
		            }
		            System.out.println();
		        }
		        
		        System.out.println();
				 System.out.println();



		//* * * * *
		//* * * * *
		//* * * * *
		//* * * * *
		//* * * * *

		}
		}
