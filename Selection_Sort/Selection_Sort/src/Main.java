import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Define an array with size of 10 items. 
		int[] intarray = new int[10];
		//Define a random object.
		Random rand = new Random();
		
		//Populate the array with the random object between 0 and 20.
		for(int i = 0; i < intarray.length; i++) {
			
			intarray[i] = rand.nextInt(20);
		}
		
		//Sort the array by calling the sorted_array method which takes an integer array as its parameter.
		int[] sortedarray = sorted_array(intarray);
		
		//Print out the array items. 
		for(int i = 0; i < sortedarray.length; i++) {
			System.out.println(sortedarray[i]); 
		}

	}//end of main method

	public static int[] sorted_array(int[] array) {
		
		//Create a counter for the while loop
		int counter = 0;
		
		//This while loop will increment the counter variable after every iteration. If it's less than the length of the array, keep going.
		while(counter < array.length) {
		
			//Define a lowest_number variable as the counter's value in the array. If counter is 0, then this value would be array[0]
			int lowest_number = array[counter];
			//Duplicate the counter
			int index_of_lowest_number = counter; 
			
			//Loops through the array starting at the counter value. 
			//If the number lowest_number is comparing to is lower than itself, mark the index of the array. 
			for(int i = counter; i < array.length; i++) {
				
				if(lowest_number > array[i]) {
					
					lowest_number = array[i];
					index_of_lowest_number = i;
				}
				
			}//end of for loop
			
			//Do a swap: 
			//Define a temporary variable which takes the value at the index of the variable index_of_lowest_number;
			int temp = array[index_of_lowest_number];
			//array at the index of index_of_lowest_number becomes the number of the value of the array at the counter. 
			array[index_of_lowest_number] = array[counter];
			//Array value at counter becomes the lowest number.
			array[counter] = temp;
			
			//Increment the counter. 
			counter++;
			
		}//end of while
		
		return array;
		
	}//end of method
	
}//end of class
