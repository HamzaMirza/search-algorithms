package search;

public class FindNearestElement {

	public static void main(String[] args) {
		int[] array = { 1, 9, 10, 12, 13, 14, 18 };
		int index = findNearestElement(array, 11);	//Calling the function to get nearest value.
		if (index == -1) // If array is empty
			System.out.println("Array empty");
		System.out.println("Nearest Element is " + array[index]); // Printing the element.
	}

	static int findNearestElement(int arr[], int tofind) {
		if (arr.length <= 0)	//if array length is empty.
			return -1;
		else if (arr[0] > tofind)	// if first element is greater than the search value.
			return 0;
		else if (arr[arr.length - 1] < tofind)
			return arr.length - 1;	// if last element is less than the search value.
		return binarySearchRecursive(arr, tofind, 0, arr.length - 1); // Call binary search

	}

	static int binarySearchRecursive(int arr[], int tofind, int start, int end) {
		if (end - start < 2) { // if the difference between the pointers is less than 2 it means that there is only one element remaining
			if (tofind - arr[start] > arr[end] - tofind) // finding the minimum difference value.
				return end;
			else
				return start;
		}
		int mid = (end + start) / 2;

		if (arr[mid] < tofind)
			return binarySearchRecursive(arr, tofind, mid, end);
		else if (arr[mid] > tofind)
			return binarySearchRecursive(arr, tofind, start, mid);
		else {
			return mid;
		}

	}

}
