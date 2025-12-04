import java.util.Random;

public class SortingClass {
	
	Random random = new Random();
	private int[] arrayToSort;

	
	public SortingClass(int[] arrayToSort) {
		this.setArrayToSort(arrayToSort);
	}
	
	
	
	//MERGE SORT PARTS
	public void mergeSortChoose(int[] arrayToSort, String numberOfPartions) { // choosing which version of merge gonna done
		
		if(numberOfPartions.equals("twoparts")) {
			
			mergeSortForTwo(arrayToSort, 0, arrayToSort.length - 1);
		}
		
		else if(numberOfPartions.equals("threeparts")) {
			
		}
			mergeFor3wayMain(arrayToSort);
		}	
	private void mergeFortwo(int[] arrayToSort, int l, int m, int r) {
		int n1 = m - l + 1; // length of arrays
	    int n2 = r - m; 
// 			Create temp arrays
	    int L[] = new int [n1]; //creates new array for left part
	    int R[] = new int [n2]; // creates new array for right part

	    for (int i=0; i<n1; ++i)  //fills two array according to which parts should
	        L[i] = arrayToSort[l + i]; 
	    for (int j=0; j<n2; ++j) 
	        R[j] = arrayToSort[m + 1+ j]; 


	 // Initial indexes of first and second subarrays
	    int i = 0, j = 0;  
	    
	    // Initial index of merged subarray array
	    int k = l; 
	    while (i < n1 && j < n2) 
	    { 
	        if (L[i] <= R[j]) 
	        { 
	        	arrayToSort[k] = L[i]; 
	            i++; 
	        } 
	        else
	        { 
	        	arrayToSort[k] = R[j]; 
	            j++; 
	        } 
	        k++; 
	    } 
	    // Copy remaining elements of L[] if any
	    while (i < n1) 
	    { 
	    	arrayToSort[k] = L[i]; 
	        i++; 
	        k++; 
	    } 
	    // Copy remaining elements of R[] if any
	    while (j < n2) 
	    { 
	    	arrayToSort[k] = R[j]; 
	        j++; 
	        k++; 
	    } 

	}
	private void mergeSortForTwo(int[] arrayToSort, int l, int r) {
		
		
		if (l < r) {
			// Find the middle point
			int m = (l+r)/2;
			
			// Sort first and second halves
			mergeSortForTwo(arrayToSort, l, m);
			mergeSortForTwo(arrayToSort, m+1, r);
			
			// Merge the sorted halves
			mergeFortwo(arrayToSort, l, m, r);
		}
	}
	private void mergeSortForThree(int[] arrayToSort, int l, int r, int[] destArray){
		
		if(r - l < 2)
			return;
			// finding middle of left part
			int mid1 = l + ((r - l) / 3);
			// finding middle of right part
			int mid2 = l + 2 * ((r - l) / 3) + 1;
			
			// Sort first, second and third halves
			mergeSortForThree(destArray, l, mid1, arrayToSort);
			mergeSortForThree(destArray, mid1, mid2, arrayToSort);
			mergeSortForThree(destArray, mid2, r, arrayToSort);
			
			// Merge the sorted halves
			mergeForThree(destArray, l, mid1, mid2, r, arrayToSort);
			
	}
	private void mergeForThree(int[] arrayToSort, int l, int mid1, int mid2, int r, int[] destArray) {
		
		int start = l; int m1 = mid1; int m2 = mid2; int low = l; // choose 
		
		// choose smaller of the smallest in the three ranges
		while((start < mid1) && (m1 < mid2) && (m2 < r)) {
			
			if(arrayToSort[start] < arrayToSort[m1]) {
				
				if(arrayToSort[start] < arrayToSort[m2]) {
					destArray[low++] = arrayToSort[start++];
				}	
					
				else
					destArray[low++] = arrayToSort[m2++];
			}
			else 
			{
				if(arrayToSort[m1] < arrayToSort[m2])
					destArray[low++] = arrayToSort[m1++];
				else
					destArray[low++] = arrayToSort[m2++];		
			}
		}
		
		// case where first and second ranges have
        // remaining values
		while(start < mid1 && m1 < mid2) {
			 
			if (arrayToSort[start] < arrayToSort[m1])
					destArray[low++] = arrayToSort[start++];
	            else
	            	destArray[low++] = arrayToSort[m1++];
		}
		
		// case where second and third ranges have
        // remaining values
		while((m1 < mid2) && (m2 < r)) {
			
			if(arrayToSort[m1] < arrayToSort[m2])
				destArray[low++] = arrayToSort[m1++];
			else
				destArray[low++] = arrayToSort[m2++];
		}
		
		// case where first and third ranges have
        // remaining values
		while((start < mid1) && (m2 < r)) {
			
			if(arrayToSort[start] < arrayToSort[m2])
				destArray[low++] = arrayToSort[start++];
			else
				destArray[low++] = arrayToSort[m2++];
		}
		
		// copy remaining values from the first range
		while(start < mid1) {
			destArray[low++] = arrayToSort[start++];
		}
		// copy remaining values from the second range
		while(m1 < mid2) {
			destArray[low++] = arrayToSort[m1++];
		}
		// copy remaining values from the third range
		while(m2 < r) {
			destArray[low++] = arrayToSort[m2++];
		}
		
		
		
	}
	private void mergeFor3wayMain(int[] arrayToSort) {
		
		 // if array of size is zero returns null
        if (arrayToSort == null)
            return;
 
        // creating duplicate of given array
        int[] fArray = new int[arrayToSort.length];
 
        // copying elements of given array into
        // duplicate array
        for (int i = 0; i < fArray.length; i++)
            fArray[i] = arrayToSort[i];
 
        // sort function
        mergeSortForThree(fArray, 0, arrayToSort.length, arrayToSort);
 
        // copy back elements of duplicate array
        // to given array
        for (int i = 0; i < fArray.length; i++)
        	arrayToSort[i] = fArray[i];
	}
	
	
	
	//QUICK SORT PARTS
	public void quickSortChoose(int[] arrayToSort, String pivotType) { // choose which version of quick sort gonna done
		
		if(pivotType.equals("1")) {
			quickSort(arrayToSort, 0, arrayToSort.length - 1, 1);
		}
		else if(pivotType.equals("2")) {
			quickSort(arrayToSort, 0, arrayToSort.length - 1, 2);
		}
		else if(pivotType.equals("3")) {
			quickSort(arrayToSort, 0, arrayToSort.length - 1, 3);
		}
	}
	private void quickSort(int[] arrayToSort, int low, int high, int option) {
		if(low < high) { // checks array is not empty

			int pivot = partition(arrayToSort, low, high, option);
			
			
			
			quickSort(arrayToSort, low, pivot - 1, option);
			quickSort(arrayToSort, pivot + 1, high, option);
		} 
	}
	private int partition(int[] arrayToSort, int low, int high, int option) {
		
		int pivotIndex; // hold pivotIndex
		int i = 0; // returning pivot value;

		
		
		if(option == 1) { // for choose first element pivot
			  pivotIndex = low; // choose pivot as first element
			  i = pivotLow(arrayToSort, low, high);
			  return i; //return pivot 
					  
			 
		}
		else if(option == 2) { //choosing random element pivot option
			
			 pivotIndex = random.nextInt(high - low + 1) + low;  //choose pivot random element
			 i = pivotHigh(arrayToSort, low, high);
			 return i;
	         
	         
			 
		}
		else if(option == 3) { // choosing middle in the among of first middle and last index value
			
			 int middleIndex = low + (high - low) / 2; // choose middle value among first middle and last index values 
			 int middleValue = arrayToSort[middleIndex]; //choose middle index value
			 int lowValue = arrayToSort[low];//choose first index value
			 int highValue = arrayToSort[high];//choose last index value
			
			 if((lowValue > middleValue) && (lowValue < highValue)|| (lowValue < middleValue) && (lowValue > highValue)) { // this parts select middle value 
				 pivotIndex = low;
				 i = pivotLow(arrayToSort, low, high); // 
				 return i; // return minus 1 becasue 
				 
			 }
			 
			 else if((middleValue >= lowValue) && (middleValue <= highValue)|| (middleValue <= lowValue) && (middleValue >= highValue)) {// this parts select middle value 
				 pivotIndex = middleIndex;
				 i = pivotMid(arrayToSort, low, high);
				 return i + 1; // return one added because if pivot is middle index i should'nt include pivot in line 190 
			 }
				
			 
			 else {// this parts select middle value 
				 pivotIndex = high;
				 i = pivotHigh(arrayToSort, low, high);
				 return i;
			 }
			 
			}
		return 0; 
		}
	private int pivotHigh(int[] arrayToSort, int low, int high) {
		int j = 0;
		int i = 0;
		int temp;
		      
        int pivotValue = arrayToSort[high]; // choose pivot value as high index
        
         i = low - 1; // pointer for top left - 1
        
        for(j = low; j < high; j++) { // j is pointer for top left
       	 
       	 if(arrayToSort[j] <= pivotValue) { // if the current element smaller than the pivot
       		 i++;//Increment index of smaller element
       		 temp = arrayToSort[i];
   	         arrayToSort[i] = arrayToSort[j];
   	         arrayToSort[j] = temp;
       	 }
       		 
         }
          i++;
		  temp = arrayToSort[i]; //swaps pivot into the middle
		  arrayToSort[i] = arrayToSort[j]; 
		  arrayToSort[j] = temp;
		  return i;
	}
	private int pivotLow(int[] arrayToSort, int low, int high) {
		int i = 0;
		int j = 0;
		int temp;
		
		
		
		int pivotValue = arrayToSort[low]; // pivot sets top left 
		  i = high + 1; // pointer for top right
		  
		  for(j = high; j > low; j--) {
			  if(arrayToSort[j] > pivotValue) { // if the current element bigger than pivot
				  i--;
				  temp = arrayToSort[i]; // swaps bigger value 
		          arrayToSort[i] = arrayToSort[j];
		          arrayToSort[j] = temp;
			  }
		  }
		  i--;
		  temp = arrayToSort[i]; //swaps pivot value into the middle
		  arrayToSort[i] = arrayToSort[j]; 
		  arrayToSort[j] = temp;
		  return i;
	}
	private int pivotMid(int[] arrayToSort, int low, int high) { // Hoare partition
		int i = 0;
		int j = 0;
		int temp;
		int midIndex = low + (high - low) / 2;
		
		int pivotValue = arrayToSort[midIndex];
		i = low - 1; //pointer for top left - 1
		j = high + 1; // pointer for top right + 1
		
		while(true) { // infinite loop
			
			do { // checks left pointer value  is smaller than pivot
				i++;
			} while (arrayToSort[i] < pivotValue);
			
			do { // checks right pointer value is bigger than pivot
				j--;
			} while (arrayToSort[j] > pivotValue);
			
			if(i >= j) // if pointers crossed than thats means completed
				return j;
			 
			  temp = arrayToSort[i]; // swaps pointer values according to which one is big or which one is small
			  arrayToSort[i] = arrayToSort[j]; 
			  arrayToSort[j] = temp;
			 
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public int[] getArrayToSort() {

		return arrayToSort; 
	}
	public void setArrayToSort(int[] arrayToSort) {
		this.arrayToSort = arrayToSort;
	}
}
