package com.fileOperation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*1st file create  program */

public class FileCreate {
	
	public void createFile(File file) {
		String fileContext = "12 A 34 B 56 C 78 D 9 E 10 F 11 G 12 H 13 I 14 J 15 K 16 L 17 M 18 N 19 O 20 P" +" "+ file;
		FileWriter writer = null;
		try {
			file.createNewFile();
			try {
				writer = new FileWriter(file);
				System.out.println("File contains some data");
				writer.write(fileContext);
			} catch (IOException e) {
				// 2nd try inside try-catch block
				e.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					// 3rd finally inside try-catch
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// 1st try-catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		FileCreate fileCreate = new FileCreate();
		File file = new File("First.txt");
		System.out.println("File created");
		fileCreate.createFile(file);
	}

}
