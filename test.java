import java.io.Console;
import java.lang.ref.Cleaner;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;


public class test{

	public static void main(String[] args) {
		
		Random rn = new Random();
		
		
		
		while(true) {
			
		int n = 100; // array size
		int[] array = new int[n];
		for(int i = 0; i < array.length; i++) {
			int a = rn.nextInt(n);
			array[i] = a; // for random elements array
			//array[i] = i increasing elements of array
			//array[i] = n - i decreasing elements of array
			//array[i] = n equal elements of array
		}
		SortingClass arrayToSort = new SortingClass(array);
		Scanner scn = new Scanner(System.in);
		
		System.out.println("---------SELECT SORT ALGORITHM-----------");
		System.out.println("1-MergeSort");
		System.out.println("2-QuickSort");
		System.out.println("3-Exit");
		

		
		int option = scn.nextInt();
		
		if(option == 1) {
		System.out.flush();
		System.out.println("---------Merge Sort Selection----------");
		System.out.println("1-ONE PART DIVIDE");
		System.out.println("2-THREE PART DIVIDE");
		
		int option2 = scn.nextInt();
		
		if(option2 == 1) {
			System.out.print("Unsorted: ");
			displayArray(array);
			
			long startTime = System.currentTimeMillis();
			arrayToSort.mergeSortChoose(array, "twoparts");
			long estimatedTime = System.currentTimeMillis() - startTime;
			
			System.out.println();
			System.out.print("Sorted: ");
			displayArray(array);
			System.out.println();
			System.out.println("Time: " + estimatedTime + "ms");
			for(int j = 0; j < 5; j++)
				System.out.println();
		}
		else if(option2 == 2) {
			System.out.print("Unsorted: ");
			displayArray(array);
			
			long startTime = System.currentTimeMillis();
			arrayToSort.mergeSortChoose(array, "threeparts");
			long estimatedTime = System.currentTimeMillis() - startTime;
			
			System.out.println();
			System.out.print("Sorted: ");
			displayArray(array);
			System.out.println();
			System.out.println("Time: " + estimatedTime + "ms");
			
			for(int j = 0; j < 5; j++)
				System.out.println();
		}
		
		}
		else if(option == 2) {
			System.out.println("---------Quick Sort Selection----------");
			System.out.println("1-First element pivot");
			System.out.println("2-Random element pivot");
			System.out.println("3-MidOfFirstMidLastElement");
			
			int option3 = scn.nextInt();
			
			if(option3 == 1) {
				System.out.print("Unsorted: ");
				displayArray(array);
				
				long startTime = System.currentTimeMillis();
				arrayToSort.quickSortChoose(array, "1");
				long estimatedTime = System.currentTimeMillis() - startTime;
				
				System.out.println();
				System.out.print("Sorted: ");
				displayArray(array);
				System.out.println();
				System.out.println("Time: " + estimatedTime + "ms");
				
				for(int j = 0; j < 5; j++)
					System.out.println();
				
			}
			
			else if(option3 == 2) {
				System.out.print("Unsorted: ");
				displayArray(array);
				
				long startTime = System.currentTimeMillis();
				arrayToSort.quickSortChoose(array, "2");
				long estimatedTime = System.currentTimeMillis() - startTime;
				
				System.out.println();
				System.out.print("Sorted: ");
				displayArray(array);
				System.out.println();
				System.out.println("Time: " + estimatedTime + "ms");
				
				for(int j = 0; j < 3; j++)
					System.out.println();
			}
			
			
			else if(option3 == 3) {
				
				System.out.print("Unsorted: ");
				displayArray(array);
				
				long startTime = System.currentTimeMillis();
				arrayToSort.quickSortChoose(array, "3");
				long estimatedTime = System.currentTimeMillis() - startTime;
				
				System.out.println();
				System.out.print("Sorted: ");
				displayArray(array);
				System.out.println();
				System.out.println("Time: " + estimatedTime + "ms");
				
				for(int j = 0; j < 5; j++)
					System.out.println();
				
			}
		}
		else if(option == 3) {
			System.out.println("goodbye");
			System.exit(option);
			scn.close();
			
		}
		
		}
		
	
	}
	
	public static void displayArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}


