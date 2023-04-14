package com.fileException;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
	String str;
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public void createFile(File file) {
		String fileContext = "12 A 34 B 56 C 78 D 9 E 10 F 11 G 12 H 13 I 14 J 15 K 16 L 17 M 18 N 19 O 20 P" + file;

		FileWriter writer = null;
		FileReader fileReader = null;

		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;

		String intString = "";
		String string = "";
		try {
			file.createNewFile();
			try {
				writer = new FileWriter(file);
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
		///////////////////////////////////////////////////////

		try {
			fileReader = new FileReader(file);
			int i;
			try {
				System.out.println("Printing data : " + " " + file);
				while ((i = fileReader.read()) != -1)
					System.out.print(" " + (char) i);
			} catch (IOException e1) {
				// 2nd OF 1st try-catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// 2nd try-catch block
			e.printStackTrace();
		}
		/******** Reading file data using FileInPutStream *******/
		try {
			fileInputStream = new FileInputStream(file);
			String outputString = null;
			System.out.println("*****************");
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

			System.out.println("Separating Int value and String values from" + " combined " + "String " + "\n"
					+ "String value : " + fileContext);
			String a = outputString;
			int i;
			for (i = 0; i < a.length(); i++) {
				char c = a.charAt(i);
				if ('0' <= c && c < '9')
					intString = intString + c;
				if ('A' <= c && c <= 'Z')
					string = string + c;
				if ('a' <= c && c <= 'z')
					string = string + c;
			}
		} catch (Exception e) {
			// 3rd try-catch
			e.printStackTrace();
		}
		System.out.println(intString);
		System.out.println("string to integer");
		// int t=Integer.parseInt(intString);
		// System.out.println(t); //string to integer
		 setStr(intString);
		System.out.println(string);
		

		/********************* Writing data in file using FileOutputStream ***************/

		try {

			fileOutputStream = new FileOutputStream("newTest.txt");

			try {
				fileOutputStream.write(intString.getBytes());
				fileOutputStream.write(string.getBytes());
			} catch (Exception e) {

				e.printStackTrace();
			}

			System.out.println("Content writting is done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			try {

				fileOutputStream.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				fileOutputStream.flush();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public void readWriteFile(File file) {

		/*********************
		 * Reading & Writing data in file using BuffredStream
		 ***************/
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		System.out.println("inside readWriteFile : " + file.toString());
		try {

			bufferedReader = new BufferedReader(new FileReader(file));
			bufferedWriter = new BufferedWriter(new FileWriter("newFile.txt"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("Datatxt"))
					System.out.println("inside readWriteFile : ");

				line = line.replace("Datatxt", " " + "This is new line added");
				bufferedWriter.write(line + "\n");
				bufferedWriter.write("New line added after replacing above line content");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bufferedWriter != null)
					bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void readFile(File file) {
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			if (System.getProperty("os.name").toLowerCase().contains("windows")) {
				String cmd = "rundll32 url.dll,FileProtocolHandler " + file.getCanonicalPath();
				Runtime.getRuntime().exec(cmd);
			} else {
				Desktop.getDesktop().edit(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int i;
		try {
			while ((i = fr.read()) != -1)
				System.out.print((char) i);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		CreateFile fileCreate = new CreateFile();
		String fileName = "Data.txt";
		File file = new File(fileName);
		fileCreate.createFile(file);
		System.out.println("*******************");
		String readFileName = "D:\\Eclipse Program\\Exception\\Data.txt";
		File readFile = new File(readFileName);
		fileCreate.readFile(readFile);
		String newFileName = "new.txt";
		File newFile = new File(newFileName);
		fileCreate.readWriteFile(newFile);

	}

}
