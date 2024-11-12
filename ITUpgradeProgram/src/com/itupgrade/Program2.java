package com.itupgrade;

public class Program2 {
	
	static int iSum =0;
	
	static int arr[] = {1,2,3,4,5};
	
	public static int sum()
	{		
		for(int i = 0; i<arr.length; i++)
		{
			iSum = iSum +arr[i];
			
			
		}
		return iSum;
	}
	public static void main(String[] args) {
		
		sum();
		
		System.out.println("Addition of array elements : "+iSum);
		
	}
}
