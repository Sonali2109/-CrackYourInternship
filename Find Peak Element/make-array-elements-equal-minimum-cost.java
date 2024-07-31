import java.io.*;
public class Solution {

	// Utility method to compute cost, when
	// all values of array are made equal to X
	public static int computeCost(int arr[], int N,int X)
	{
  		int cost = 0;
  		for (int i = 0; i < N; i++)
  			cost += Math.abs(arr[i] - X);
  		return cost;
	}

	// Method to find minimum cost to make all
	// elements equal
	public static int minCostToMakeElementEqual(int arr[],int N)
	{
    		int low, high;
    		low = high = arr[0];
    
    		// setting limits for ternary search by
    		// smallest and largest element
    		for (int i = 0; i < N; i++) {
    			if (low > arr[i])
    				low = arr[i];
    			if (high < arr[i])
    				high = arr[i];
  		}
  
  		while ((high - low) > 2) 
      {			
    			int mid1 = low + (high - low) / 3;
    			int mid2 = high - (high - low) / 3;
    
    			int cost1 = computeCost(arr, N, mid1);
    			int cost2 = computeCost(arr, N, mid2);
    
    			// if mid2 point gives more total cost,
    			// skip third part
    			if (cost1 < cost2)
    				high = mid2;
    
    			// if mid1 point gives more total cost,
    			// skip first part
    			else
    				low = mid1;
  		}

  		return computeCost(arr, N, (low + high) / 2);
  }
}
