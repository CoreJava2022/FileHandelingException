package com.fileException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
	public static void main(String[] args) {
		String fileName ="JavaClassNobel.txt";
		File file=new File(fileName);
		FileWriter writer=null;
		try{
			file.createNewFile();
			System.out.println("File create");
			writer=new FileWriter(file);
			try{
				System.out.println("writing something into that file");
				String fileContext="Java class content"+"Java File Resource";
				writer.write(fileContext);
			}catch(IOException e){
				e.printStackTrace();
			}
			finally {
				writer.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
