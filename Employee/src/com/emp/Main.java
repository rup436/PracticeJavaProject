package com.emp;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		 
		Set<Employee> employee = new HashSet<Employee>();
		Employee employee2 = new Employee(1, "Rupesh", "kamshet");
		employee.add(employee2);
		Employee employee3 = new Employee(1, "Ashsih", "kamshet");
		System.out.println(employee2.hashCode());
		employee.add(employee3);
		System.out.println(employee3.hashCode());

		
		
		System.out.println(employee);
		
	}
}
