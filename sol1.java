// Java implementation of the approach 
import java.util.*; 

class GFG 
{ 

// Function to get the nth ugly number 
static int uglyNumber(int n) 
{ 
	// To store ugly numbers 
	int []ugly = new int[n]; 
	int i2 = 0, i3 = 0, i5 = 0; 
	int next_multiple_of_2 = 2; 
	int next_multiple_of_3 = 3; 
	int next_multiple_of_5 = 5; 
	int next_ugly_no = 1; 

	ugly[0] = 1; 
	for (int i = 1; i < n; i++) 
	{ 
		next_ugly_no = Math.min(next_multiple_of_2, 
					Math.min(next_multiple_of_3, 
								next_multiple_of_5)); 
		ugly[i] = next_ugly_no; 
		if (next_ugly_no == next_multiple_of_2) 
		{ 
			i2 = i2 + 1; 
			next_multiple_of_2 = ugly[i2] * 2; 
		} 
		if (next_ugly_no == next_multiple_of_3) 
		{ 
			i3 = i3 + 1; 
			next_multiple_of_3 = ugly[i3] * 3; 
		} 
		if (next_ugly_no == next_multiple_of_5) 
		{ 
			i5 = i5 + 1; 
			next_multiple_of_5 = ugly[i5] * 5; 
		} 
	} 
	return next_ugly_no; 
} 

// Function to return the length of the 
// maximum sub-array of ugly numbers 
static int maxUglySubarray(int arr[], int n) 
{ 
	HashSet<Integer> s = new HashSet<>(); 
	int i = 1; 

	// Insert ugly numbers in set 
	// which are less than 1000 
	while (true) 
	{ 
		int next_ugly_number = uglyNumber(i); 
		if (next_ugly_number > 1000) 
			break; 
		s.add(next_ugly_number); 
		i++; 
	} 

	int current_max = 0, max_so_far = 0; 

	for (i = 0; i < n; i++) 
	{ 

		// Check if element is non ugly 
		if (!s.contains(arr[i])) 
			current_max = 0; 

		// If element is ugly, than update 
		// current_max and max_so_far accordingly 
		else
		{ 
			current_max++; 
			max_so_far = Math.max(current_max, 
								max_so_far); 
		} 
	} 
	return max_so_far; 
} 

// Driver code 
public static void main(String[] args) 
{ 
	int arr[] = { 1, 0, 6, 7, 320, 800, 100, 648 }; 
	int n = arr.length; 
	System.out.println(maxUglySubarray(arr, n)); 
} 
} 


