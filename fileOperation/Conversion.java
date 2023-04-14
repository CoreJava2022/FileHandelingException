package com.fileOperation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Conversion {
		public void readFile(File  file){
			BufferedReader bufferedReader = null;
			String intString;
			try {
				bufferedReader = new BufferedReader(new FileReader(file));
				String line;
				
				while ((line = bufferedReader.readLine()) != null) {
						System.out.println("inside readWriteFile : "+line);
						intString =line.replaceAll("[^0-9]", ""); 
						 System.out.println(intString);
						 
						 char[] list = intString.toCharArray();

							int[] num = new int[list.length];
							for (int i = 0; i < list.length; i++) {
								num[i] = list[i] - '0';
							}
							for (int i = 0; i < num.length; i++) {
								System.out.print(num[i]);
							} 
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
						bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		public static void main(String args[]){
			Conversion conversion = new Conversion();
			File file1 = new File("newTest.txt");
			conversion.readFile(file1);	
		}
	}
	
	

