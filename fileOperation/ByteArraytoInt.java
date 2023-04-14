package com.fileOperation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArraytoInt {

	public static void main(String[] args) throws IOException {
        File f=new File("new.txt");
        
        byte[]b={1,2,3,4,5};
        ByteArrayInputStream is=new ByteArrayInputStream(b);
        int i;
        while((i=is.read())!=-1) {
            System.out.println((int)i); 
            FileOutputStream f1=new FileOutputStream(f);
            FileOutputStream f2=new FileOutputStream(f);
            ByteArrayOutputStream b1=new ByteArrayOutputStream();
            b1.write(6545);
            b1.writeTo(f1);
            b1.writeTo(f2);
            b1.close();
            
            
            byte[] byteArray = new byte[] {123, 12, 87};
            int[] intArray = new int[byteArray.length];

            // converting byteArray to intArray
            for (int i1 = 0; i1 < byteArray.length; intArray[i1] = byteArray[i1++]);

            System.out.println(Arrays.toString(intArray));
            
            String fileContext = "12 34  56  78  9 ";
            try {
            int t=Integer.parseInt(fileContext);
            
			System.out.println("String convert into integer :"+t);
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
        }
	}
}
