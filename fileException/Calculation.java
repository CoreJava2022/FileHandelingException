package com.fileException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

abstract class MathOpe {
	int z;
	public void add(int a, int b) {
		 z = a + b;
		System.out.println("Addition is :" + z);
	}

	public abstract void division(int a, int b) throws Exception;
}

public class Calculation extends MathOpe {
	public void division(int a, int b) {
		try {
			int c = a / b;
			String fileName = "MathOpe.txt";
			File file = new File(fileName);
			FileWriter writer = null;
			boolean var = false;
			System.out.println(var);
			try {
				var = file.createNewFile();
				if (var) {
					System.out.println("File is Created :: " + fileName);
				} else {
					System.out.println("File is Already Created :: " + fileName);
				}
				writer = new FileWriter(file);
				try {
					writer.write("Addition of Two Numbers ::" + z + "\n Division of Two numbers :: " + c);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					writer.close();
				}
			} catch(ArithmeticException e) {
				e.printStackTrace();
			}finally {
			System.out.println("Any number divide by zero:");
			}
			}catch(Exception e) {
			e.printStackTrace();
			} 
	}

	public static void main(String[] args) {
		Calculation cal = new Calculation();
		cal.add(10, 20);
		cal.division(10, 2);
	}

}
