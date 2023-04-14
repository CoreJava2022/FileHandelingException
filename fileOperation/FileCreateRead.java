package com.fileOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileCreateRead {
	
	FileReader fileReader = null;
	
	public void readFile(File file) {
	try {
		fileReader = new FileReader(file);
		int i;
		try {
			System.out.println("Printing data : " + " " + file);
			while ((i = fileReader.read()) != -1)
				System.out.print(" " + (char) i);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		
		FileCreateRead fileCreateRead = new FileCreateRead();
		File file = new File("First.txt");
		fileCreateRead.readFile(file);
	}

}
