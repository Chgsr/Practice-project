package com.automation.Scripts;

public class numbersformat {
	
	public static void main(String[] args) {
		
		for (int x = 1; x <= 5; x++) {
			for (int y = 1; y <= x; y++) {
			System.out.print(y+" ");
			}
		System.out.println();
		}
		
		int a = 0, b = 1, c, i, count = 10;
		// To print 0 and 1
		System.out.print(a + " " + b);
		// loop starts from 2. We have already printed 0 and 1 in the previous step
		for (i = 2; i < count; i++) {
			c = a + b;
			System.out.print(" " + c);
			a = b;
			b = c;
		}
	}

}
