package com.fileOperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileBufferRead {

	public void fileRead(File file){
		
		FileReader fileReader=null;
		FileWriter fileWriter=null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		System.out.println("inside File Read : " + file.toString());
		try {
			//file.createNewFile();
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
	public static void main(String[] args) {
		FileBufferRead fileBufferRead = new FileBufferRead();
		//String newFileName = "new.txt";
		File newFile = new File("new.txt");
		//fileCreate.readWriteFile(newFile);
		fileBufferRead.fileRead(newFile);
	}

}
