package com.fileOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringToIntArray {

	public void readFile(File file) {
		
		FileInputStream fileInputStream = null;
		String intString = "";
		
		try {
			
			fileInputStream = new FileInputStream(file);
			String string = null ;
			
			try { 
				
				byte[] bytes = new byte[2000];
				while(fileInputStream.read(bytes) != -1) 
					string = new String(bytes);
				System.out.println("String is : "+string);
				
				for(int i = 0;i<string.length();i++) {
					char c = string.charAt(i);
					if('0' <= c && c <= '9')
						intString = intString+c;
				}
				
				char [] charArray = intString.toCharArray();
				
				int [] num = new int[charArray.length];
				System.out.print("int [] is : ");
				for (int i=0; i<charArray.length;i++) {
					
					System.out.print(num[i] = charArray[i] - '0');
					System.out.print(", ");
				}
				
				List<Integer> integerList = new ArrayList<Integer>(num.length);
				
				for(Integer integer : num) {
					integerList.add(integer);
				}
				
				System.out.println("\nsize of integerList : "+integerList.size());
				
				System.out.println("value of integerList : "+integerList);
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		StringToIntArray stringToIntArray = new StringToIntArray();
		String fileName = "newTest.txt";
		File file = new File(fileName);
		stringToIntArray.readFile(file);
	}

}
