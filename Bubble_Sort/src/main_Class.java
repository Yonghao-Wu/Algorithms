import java.util.Random;

public class main_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Create an integer array which houses 10 ints and a instantiate a new random object
		int[] intarray = new int[10];
		Random rand = new Random(); 
		
		//Fill the integer array with the random objects through a loop
		for(int i = 0; i < intarray.length; i++) {
			intarray[i] = rand.nextInt(20);
		}//end of for
		
		//Create a new integer array named sorted_array, which calls the sort method and pass the previous integer 
		//array with random objects to the method to be sorted
		int[] sorted_array = sort(intarray); 
		
		//print out the sorted elements in the sorted array
		for(int i = 0; i < sorted_array.length; i++) {
			System.out.println(sorted_array[i]);
		}//end of for
		
	}//end of main
	
	public static int[] sort(int[] array) {
		
		//create an integer which the while loop will check, if it's satisfied, it'll stop, otherwise it'll continue on. 
		int array_counter = 0; 
		
		//if array_counter does not equate the length of the array's length (which is 10), keep going. 
		while(array_counter != array.length) {
			
			//create an int object which houses the lowest number in the array. This code is executed on every while iteration
			//get_lower_number is a method
			int lowest_number = get_lower_number(array, array_counter);
			
			//starting at the end of the array, count backwards to the start of the array and in the process of doing so, 
			//check each two numbers to see which is smaller, if that number is smaller, put it to the left side.
			//For example: we have an array of array[1, 5, 8, 3, 2]; the code below starts with array[4] which is 2, compares it with
			//array[3] which is 3. 3 is greater than 2, so 2 would now be array[3] and 3 would be array[4]. 
			//Then array[3] which is 2 would be compared with array[2] which is 8. 8 is greater than 2 so they swap places. 
			for(int num1 = array.length-1; num1 > array_counter; num1--) {
				
				int num2 = num1 - 1; 
				
				boolean greater = comparer(array[num1], array[num2]);
				
				if(greater == false) {
					int temp = array[num2]; 
					array[num2] = array[num1];
					array[num1] = temp;
					
				}//end of if
			}//end of for
			
			//checks to see if the lowest number is at the first index of the array. The first index of the array is always incremental
			//so it doesn't check the numbers that are already at their place on the left most side. 
			boolean at_first_index = lowest_at_first_index(lowest_number, array, array_counter);
			
			//If the number is on the first index of the remaining array, increment the array_counter variable. 
			if(at_first_index == true) {
				array_counter++;
			}//end of if
			
			
		}//end of while
		
		//return the original sorted array. Notice that we're not returning another array, but the original one. 
		return array;
	}//end of sort method
	
	//=========================================================================
	
	//method to determine if the lowest number is at the lowest index of the array
	private static boolean lowest_at_first_index(int lowest_number, int[] array, int array_counter) {
		
		if(array[array_counter] == lowest_number) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//get the lowest number in the remaining array
	private static int get_lower_number(int[] array, int array_counter) {
		
		int lowest_number = array[array.length-1];
		
		for(int i = array.length-1; i > array_counter-1; i--) {
			if(array[i] < lowest_number) {
				lowest_number = array[i];
			}
		}
		
		return lowest_number;
	}
	
	//returns true if the first number is higher or equal to the second number
	//otherwise (first number is smaller than the second number) return false. 
	private static boolean comparer(int num1, int num2) {
		
		if(num1 > num2 || num1 == num2) {
			return true; 
		}
		else {
			return false; 
		}
	}

}
