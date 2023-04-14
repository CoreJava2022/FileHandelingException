package com.fileOperation;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DesktopFile {
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
		DesktopFile desktopFile = new DesktopFile();
		File file= new File("first.txt");
		desktopFile.readFile(file);
	}

}
