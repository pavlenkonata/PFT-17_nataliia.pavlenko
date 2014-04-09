package com.example.tests;

public class Sample {

	
	public static void main(String[] args) {
		String line = ",groupheader-1822777404,,!";
		String [] part = line.split(",");
		
		System.out.println(part[1]);
		System.out.println(part[2]);

	}

}
