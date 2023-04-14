package com.fileException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputStore extends MathOpe {
	public void division(int a, int b) {

		String fileName = "MathOpe.txt";
		File file = new File(fileName);
		FileWriter writer = null;
		boolean var;
		try {
			var = file.createNewFile();
			if (var) {
				System.out.println("file is created" + file);
			} else {
				System.out.println("file is Already created" + file);
			}
			writer = new FileWriter(file);

			try {
				writer.write("Addition is " + z + "\n");
				try {
					int c = a / b;
					writer.write("Division is" + c);
				} catch (ArithmeticException e) {
					e.printStackTrace();
					writer.write(e.toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		FileOutputStore cal = new FileOutputStore();
		cal.add(10, 20);
		cal.division(10, 0);

	}

}
