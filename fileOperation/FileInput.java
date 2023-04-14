package com.fileOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInput {
	
	FileInputStream fileInputStream = null;
	
	public void readFile(File file){
		
		String fileContext = "12 A 34 B 56 C 78 D 9 E 10 F 11 G 12 H 13 I 14 J 15 K 16 L 17 M 18 N 19 O 20 P" + file;
        String  intString="";
        String  string="";
		try {
			fileInputStream = new FileInputStream(file);
			String outputString = null;
			try {
				byte[] bytes = new byte[8234];
				while (fileInputStream.read(bytes) != -1)
					outputString = new String(bytes);
			} catch (IOException e) {
				// 3rd OF 1st inside try-catch
				e.printStackTrace();
			}

			// seprate int and char from string
			System.out.println("String is :" + outputString);

			System.out.println("Separating Int value and String values from combined String ");
			intString =outputString.replaceAll("[^A-Za-z]", "");  
			string =outputString.replaceAll("[^0-9]", "");  
			 
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println("seprated String : ");
		System.out.println(intString);
		System.out.println(string);
	}
	public static void main(String[] args) {
		FileInput fileInput = new FileInput();
		File file = new File("First.txt");
		fileInput.readFile(file);
	}

}
