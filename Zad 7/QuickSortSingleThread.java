// Java program for the above approach
import java.util.Date;
import java.util.Random;

public class QuickSortSingleThread{

	int start, end;
	int[] arr;

	static int partition(int start, int end, int[] arr){

		int i = start, j = end;

		// Decide random pivot
		int pivote = new Random().nextInt(j - i) + i;

		// Swap the pivote with end
		// element of array;
		int t = arr[j];
		arr[j] = arr[pivote];
		arr[pivote] = t;
		j--;

		// Start partitioning
		while (i <= j) {

			if (arr[i] <= arr[end]) {
				i++;
				continue;
			}

			if (arr[j] >= arr[end]) {
				j--;
				continue;
			}

			t = arr[j];
			arr[j] = arr[i];
			arr[i] = t;
			j--;
			i++;
		}

		// Swap pivote to its
		// correct position
		t = arr[j + 1];
		arr[j + 1] = arr[end];
		arr[end] = t;
		return j + 1;
	}

	// Function to implement
	// QuickSort method
	static void QuickSort(int start, int end, int[] arr){

		if (start < end){
			int p = partition(start, end, arr);

			// Divide array
			QuickSort(start, p - 1, arr);
	
			QuickSort(p + 1, end, arr);

		}

	}

	// Driver Code
	public static void main(String args[])
	{
		
		// int[] arr = { 54, 64, 95, 82, 12, 32, 63 };
		int[] arr = new int[100000 + 1];
		for (int i=0; i<100000; i++){
			arr[i] = new Random().nextInt(100000); 
		}
		int n = arr.length;
		
		Date d0 = new Date();
		
		QuickSort(0, n - 1, arr);

		// Print shorted elements
		// for (int i = 0; i < n; i++)
		// 	System.out.print(arr[i] + " ");

		Date d1 = new Date();

		System.out.println("Czas działania programu: " + (d1.getTime() - d0.getTime() + "[ms]"));
	}
}
