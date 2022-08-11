import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * Lab 01
 * @author Lab Group 7: Meghana Indukuri & Joseph Khamisy
 * This program implements recursive and iterative algorithms for checking if an array contains prime numbers.
 * July 6th 2022
 */
public class ArrayPrimeCheck {
    public static void main(String[] args) throws IOException
    {
        Scanner readSize = new Scanner(System.in);
        int sortMaxSize = 16;
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in)); // in order to read the entire line
        System.out.println("Enter the array size that is above 0 and not greater than " + sortMaxSize + ":");
        int sizeArray = readSize.nextInt();
        if (sizeArray > sortMaxSize) {
            sizeArray = sortMaxSize;
        }
        int[] inputNums = new int[sizeArray];

        System.out.println("Please enter the " + sizeArray + " numbers separated by a space:");
        String[] strArr;
        strArr = br.readLine().split(" "); // read user input till end of line
        for (int i=0; i<sizeArray; i++)
        {
            inputNums[i] = Integer.parseInt(strArr[i]);
        }
        System.out.println();

        // test
        System.out.println("Running iteration");
        if (isArrayPrimeIter(inputNums, sizeArray)) {
            System.out.println("Prime Array using iteration");
        } else {
            System.out.println("Not a Prime Array using iteration");
        }
        System.out.println();
        System.out.println("Running recursion");

        if (isArrayPrimeRecur(inputNums, sizeArray)) {
            System.out.println("Prime Array using recursion");
        } else {
            System.out.println("Not a Prime Array using recursion");
        }
	
        System.out.println("\nEnter any value to exit: ");
        String randEnter = br.readLine();
        readSize.close();
    }
    
    
	/*
	 * Algorithm isArrayPrimeIter (array, n)
	 * 		
	 * 		This algorithm efficently checks if an array contains all prime numbers or not using iteration. 
	 * 		Pre : array - an array of integers
	 * 			  n - the true size of array
	 * 		Post: Printed statments indicating when the method is entered and exited.
	 * 		Return: true or false
	 * 
	 * 		i=0
	 * 		loop (i < size)		
	 * 			if(array[i] <= 3)
	 * 				return !(array[i] equals 1)
	 * 			end if
	 * 			if (array[i] % 2 equals 0)
	 * 				return false
	 * 			end if
	 * 			j=3
	 * 			loop(j <= sqrt(array[i]))
	 * 				
	 * 				if(array[i]% j equals 0)
	 * 					return false;
	 * 				end if
	 * 				j+=2
	 * 			end loop
	 * 		i++
	 * 		end loop
	 * 		return true
	 * 
	 * end isArrayPrimeIter
	 */
    public static boolean isArrayPrimeIter(int[] arr, int size)
    {
        System.out.println("Entering isArrayPrimeIter");
        for (int i = 0; i < size; i++)
        {
            if(arr[i]<=3)
            {
                System.out.println("Leaving isArrayPrimeIter");
                return !(arr[i]==1);
            }

            for (int j = 3; j <= Math.sqrt(arr[i])+1; j+=2)
            {
                if (arr[i] % j == 0)
                {
                    System.out.println("Leaving isArrayPrimeIter");
                    return false;
                }
            }
        }
        System.out.println("Leaving isArrayPrimeIter");
        return true;
    }

    /*
	 * Algorithm isArrayPrimeRecur (array, n)
	 * 		
	 * 		This algorithm checks recursively if an array contains all prime numbers or not. 
	 * 		Pre : array - an array of integers
	 * 			  n - the true size of array which must be greater than 0
	 * 		Post: Printed statments indicating when the method is entered and exited.
	 * 		Return: true or false
	 *
	 * 		if(array[n-1] is not prime) // helper method to check if value in array is prime
	 * 			return false
	 * 		end if
	 * 		if(n equals 1)
	 * 			return true
	 * 		end if
	 * 		return isArrayPrimeRecur (array, n-1)
	 * 		
	 * end isArrayPrimeRecur
	 */
    public static boolean isArrayPrimeRecur(int[] arr, int size)
    {
        System.out.println("Entering isArrayPrimeRecur");
        if (!isPrimeRecur(arr[size-1], 3)) 
        {
            System.out.println("Leaving isArrayPrimeRecur");
            return false;
        }
        if (size == 1)
        {
            System.out.println("Leaving isArrayPrimeRecur");
            return true;
        }
        
        System.out.println("Leaving isArrayPrimeRecur");
        return isArrayPrimeRecur(arr, size-1);
    }
    
    /*
	 * Algorithm isPrimeRecur (number, divisor)
	 * 		
	 * 		This algorithm efficently checks if a number is prime or not using recursion. 
	 * 		Pre : number - integer to be checked
	 * 		      divisor - integer to check if is factor of number (must be the value 3 for this method to work correctly)
	 * 		Post: Printed statments indicating when the method is entered and exited.
	 * 		Return: true or false
	 * 
	 * 		if(number <=3)
	 * 			return !(number equals 1)
	 * 		end if
	 * 		if((number % divisor equals 0) or (number % 2 equals 0))
	 * 			return false;
	 * 		end if
	 * 		if(divisor> sqrt(number))
	 * 			return true;
	 * 		end if
	 * 		return isPrimeRecur(num, divisor + 2)
	 * 
	 * end isPrimeRecur
	 */
    public static boolean isPrimeRecur(int checkNum, int divisorNum)
    {
        System.out.println("Entering isPrimeRecur");
        if(checkNum<=3)
        {
            System.out.println("Leaving isPrimeRecur");
            return !(checkNum==1);
        }
        if(checkNum%divisorNum == 0 || checkNum%2 == 0 )
        {
            System.out.println("Leaving isPrimeRecur");
            return false;
        }
        if(divisorNum > Math.sqrt(checkNum))
        {
            System.out.println("Leaving isPrimeRecur");
            return true;
        }
        System.out.println("Leaving isPrimeRecur");
        return isPrimeRecur(checkNum, divisorNum+2);
    }
}
