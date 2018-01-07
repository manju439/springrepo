package com;
import java.util.ArrayList;
import java.util.Collections;


public class Demo {

	public static void main(String[] args) {
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(38);
		arr.add(27);
		arr.add(43);
		arr.add(3);
		arr.add(9);
		arr.add(82);
		arr.add(10);
		arr.add(7);
		arr.add(5);
		System.out.println(arr);
		splitSortArray(arr);
		Collections.sort(arr);
		System.out.println(arr);
	}
	
	public static void splitSortArray(ArrayList<Integer> array){
		
		int size = array.size()/2;
		if(array.size()/2>0 && array.size()%2==1)size = array.size()/2+1;
		ArrayList<Integer> firstHalf=new ArrayList<Integer>();
		ArrayList<Integer> secondHalf=new ArrayList<Integer>();
		
		for(int a=0;a<array.size();a++){ // splitting of array into 2 halves
			
			if(a<size)firstHalf.add(array.get(a));
			else secondHalf.add(array.get(a));
		}
		
		
		System.out.print(firstHalf);
		System.out.print(secondHalf);
		
		if(firstHalf.size()>1){
			System.out.println();
			splitSortArray(firstHalf);
		}
		if(secondHalf.size()>1){
			System.out.println();
			splitSortArray(secondHalf);
		}
		
		ArrayList result=new ArrayList();
		Collections.sort(firstHalf);
		Collections.sort(secondHalf);
		System.out.println(firstHalf+"   "+secondHalf);
	}
	
}
