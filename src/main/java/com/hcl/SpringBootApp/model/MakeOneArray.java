package com.hcl.SpringBootApp.model;

import java.util.Arrays;

public class MakeOneArray {
	private Integer [] array1;
	private Integer [] array2;
	private Integer [] array3;
	
	public MakeOneArray() {
		// TODO Auto-generated constructor stub
	}

	public Integer[] getArray1() {
		return array1;
	}

	public void setArray1(Integer[] array1) {
		this.array1 = array1;
	}

	public Integer[] getArray2() {
		return array2;
	}

	public void setArray2(Integer[] array2) {
		this.array2 = array2;
	}

	public Integer[] getArray3() {
		return array3;
	}

	public void setArray3(Integer[] array3) {
		this.array3 = array3;
	}

	@Override
	public String toString() {
		return "MakeOneArray [array1=" + Arrays.toString(array1) + ", array2=" + Arrays.toString(array2) + ", array3="
				+ Arrays.toString(array3) + "]";
	}
	
}
