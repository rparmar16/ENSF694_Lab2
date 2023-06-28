import java.lang.reflect.Array;
import java.util.Arrays;

public class Lab2 {
	private InteractiveCLI cli;
	public int user_array[];
	public int user_array_initial[];
	public int search_Key;
	
	public Lab2() {
		
		cli = new InteractiveCLI();
	}
	
	public void run() {
		this.cli.prompt("Enter the number of elements in the array: ");
		int size = cli.getKeyboardInteger();
		this.user_array = new int[size];
		this.user_array_initial = new int [size];
		
		for(int i = 0; i <= size-1; i++) {
			this.cli.prompt("Enter element in the array: ");
			this.user_array[i] = this.cli.getKeyboardInteger();
			this.user_array_initial[i] = user_array[i];
		}
		
		this.cli.prompt("Enter a Search Key: ");
		this.search_Key = this.cli.getKeyboardInteger();
	}
		
	public int linearSearch(int[] array, int key){
		
		for(int i = 0; i < array.length; i ++)
			{
		
			if(array[i] == key)
				return i;
			}
			return -1;
		}
	
	int interpolationSearch(int[] array, int key)
		{
		Arrays.sort(array);
		int pos = (key - array[0])/(array[array.length-1] - array[0]);
		int low = 0, high = array.length-1;
		while (low <= high){
			pos = (low + high)/2;
			if(key < array[pos])
				high = pos - 1;
			else if(array[pos] < key)
				low = pos + 1;
			else
				return pos;
		}
		return -1; 
	}
	public int newLinearSearch(int[] array, int key){
		
		
		int mid = array.length/2;
		if (key < mid) {
			for(int i = 0; i < mid; i++) {
				if(array[i] == key) {
					return i;
				}
			}
		}
		if(key >= mid) {
			for(int i = mid; i < array.length; i++) {
				if(array[i] == key) {
					return i;
				}
			}
		}
		return -1;
	}


	

	public static void main(String[] args) {
		
		Lab2 app = new Lab2();
		app.run();
		
		System.out.println("Using Linear Search: ");
		long startTime1 = System.nanoTime();
		int check = app.linearSearch(app.user_array, app.search_Key);
		long endTime1 = System.nanoTime();
		if (check != -1) {
			System.out.println("Search key FOUND at index " + check);
		}
		else {
			System.out.println("Search Key NOT FOUND");
		}
	
		System.out.println("Using Interpolation Search: ");
		long startTime2 = System.nanoTime();
		check = app.interpolationSearch(app.user_array, app.search_Key);
		long endTime2 = System.nanoTime();
		if (check != -1) {
			System.out.println("Search key FOUND at index " + check);
		}
		else {
			System.out.println("Search Key NOT FOUND");
		}
		
		System.out.println("Linear Search took " + (endTime1 - startTime1) + " miliseconds");
		System.out.println("Interpolation Search took " + (endTime2 - startTime2) + " miliseconds");
		System.out.println("The reason why linear is much faster is because Interpolation Search takes much longer for"
				+ "smaller arrays, but it is more effiecient for larger arrays.");
		
		long startTime3 = System.nanoTime();
		check = app.newLinearSearch(app.user_array, app.search_Key);
		long endTime3 = System.nanoTime();
		System.out.println("New Linear Search took " + (endTime3 - startTime3) + " miliseconds");
		System.out.println("I improved the linear search by sorting the array outside the function "
				+ "than splitting the array into two halfs. I then adapted the binary search to improve the time.");
		System.out.println("I only divided it once.");
	}
	
	

}
