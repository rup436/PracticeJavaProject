package com.itupgrade;

public class SingletonEx {
	
	private SingletonEx()
	{
		
	}
	
	public static SingletonEx getInstance()
	{
		SingletonEx singleton = new SingletonEx();
		
		System.out.println("inside getInstace method");
		
		return singleton;
	}
	
	public static void main(String[] args) {
		
		getInstance();
	}
}
