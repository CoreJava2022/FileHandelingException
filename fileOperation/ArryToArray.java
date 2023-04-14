package com.fileOperation;

import java.util.ArrayList;
import java.util.List;

public class ArryToArray {
	
public int[] convertIntArrToArrayList(String string){
	char[] list=string.toCharArray();
	int[] num = new int[list.length];
	System.out.println("print Array :");
	for (int i = 0; i < list.length; i++) {
		System.out.print(num[i]=list[i]-'0');
	}
 	return num;	
}
	public static void main(String[] args) {
		
		ArryToArray array = new ArryToArray();
		int[] intValue = array.convertIntArrToArrayList("12345678");
		System.out.println();
		System.out.println("Convert array to List");
		List<Integer> integerList=new ArrayList<Integer>(intValue.length);
		for (Integer integer : intValue) {
			integerList.add(integer);
		}
			System.out.println("size of integerList ="+integerList.size());
			System.out.println("value in list is :"+integerList);
			integerList.clear();
			System.out.println("size of intergerList after clear()= "+integerList.size());
			System.out.println("After clear"+integerList);
	}

}