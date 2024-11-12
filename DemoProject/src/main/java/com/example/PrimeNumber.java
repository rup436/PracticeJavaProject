package com.example;

import java.util.Scanner;

class PrimeNumber
{
	public static void main(String a[])
	{
		CheckPrime cp = new CheckPrime();
		
		boolean bRet;
		
		System.out.println("Enter the number:");
		Scanner scanner = new Scanner(System.in);
		
		int iValue = scanner.nextInt();
		
		bRet = cp.checkPrime(iValue);
		if(bRet == true)
		{
			System.out.println(" This is prime number: "+iValue);
		}
		
		else
		{
			System.out.println(" This is not prime number: "+iValue);
		}
		
		
	}
}

class CheckPrime
{
	boolean checkPrime(int iNo)//5
	{
		int iCnt = 0;
		boolean flag = true;
		
		for(iCnt = 2; iCnt<=iNo/2; iCnt++)
		{
			if(iNo%iCnt==0)
			{
				flag= false;
				break;
			}
		}
		
		return flag;
	}
}