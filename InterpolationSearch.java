package search;

public class InterpolationSearch {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,8,33,99,110,123};  	// Array initialization.
		int search=224;								// Number to find.
		int index= interpolationSearch(arr,search,0,arr.length-1);	// Calling the search function and saving the result in index variable.
		
		if(index==-1)	//Element did not exist in the array.
			System.out.println("The element " + search + " was not found");
		else			// Element was found in the array.
			System.out.println("The element " + search + " was found at index "+index);
	}
	private static int interpolationSearch(int[] arr, int tofind, int start, int end)
	{ 
		
		if( start > end ) // Base Condition array has been exhausted.
			return -1; 
		else if( start == end ) // Base Condition in which array size is equal to 1.
		{
			if( arr[start] == tofind ) // Found the element.
				return start;
			else						// Element not found.
				return -1;
		}
		else if(tofind > arr[end] ) // Base Condition in which element to search is greater than the maximum element of the array.
			return -1;
		
		int mid= start + ( ( tofind - arr[start] ) * ( end - start )  / ( arr[end] - arr[start] ) );

		if ( arr[mid] == tofind ) // Element found
			return mid;		
		else if ( arr[mid] < tofind ) // Element is less than the pointed position.
			return interpolationSearch(arr,tofind,mid+1,end);	// Calling the search function to search the left part of the array and returning the value.		
		else if ( arr[mid] > tofind ) // Element is greater than the pointed position.
			return interpolationSearch(arr,tofind,0,mid-1);	// Calling the search function to search the right part of the array and returning the value.
		
		return -1;	// Base return value.
	}
}
