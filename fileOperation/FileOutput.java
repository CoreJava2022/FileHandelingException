package com.fileOperation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {

	public void outputFileRead(File file) {

		String fileContext = "12 A 34 B 56 C 78 D 9 E 10 F 11 G 12 H 13 I 14 J 15 K 16 L 17 M 18 N 19 O 20 P" + " "
				+ file;

		FileOutputStream fileOutputStream = null;

		try {
			byte[] byteArr = fileContext.getBytes();
			fileOutputStream = new FileOutputStream("Second.txt");

			try {
				fileOutputStream.write(byteArr);
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

	public static void main(String[] args) {
		FileOutput fileOutput = new FileOutput();
		File file = new File("First.txt");
		// System.out.println("File created");
		fileOutput.outputFileRead(file);
	}

}
