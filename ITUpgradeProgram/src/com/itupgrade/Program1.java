package com.itupgrade;

import java.util.Scanner;

public class Program1 {
	public static void main(String arg[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter The First Number: ");
		int iNo1 = sc.nextInt();
		System.out.println("Enter The Second Number: ");
		int iNo2 = sc.nextInt();

		Program1 p = new Program1();
		int iret = p.sum(iNo1, iNo2);
		System.out.println("Addition is : " + iret);
		int iret1 = p.sub(iNo1, iNo2);
		System.out.println("subtraction  is : " + iret1);
		int iret2 = p.mult(iNo1, iNo2);
		System.out.println("multiplication  is : " + iret2);
		int iret3 = p.div(iNo1, iNo2);
		System.out.println("Division  is : " + iret3);

	}

	public int sum(int a, int b) {
		int iSum = a + b;
		return iSum;
	}

	public int sub(int a, int b) {
		int iSum = a - b;
		return iSum;
	}

	public int mult(int a, int b) {
		int iSum = a * b;
		return iSum;
	}

	public int div(int a, int b) {
		int iSum = a / b;
		return iSum;
	}
}
