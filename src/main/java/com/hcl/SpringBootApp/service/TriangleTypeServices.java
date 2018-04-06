package com.hcl.SpringBootApp.service;

import org.springframework.stereotype.Component;

@Component
public class TriangleTypeServices {
	public static final String EQUILATERAL = "Equilateral";
	public static final String ISOSCELES = "Isosceles";
	public static final String SCALENE = "Scalene";
	public static final String INVALID = "Not a triangle";

	public static String findTriangleType(int side1, int side2, int side3) {

		if (side1 == side2 && side2 == side3) {
			// all sides are equal
			return EQUILATERAL;
		} else if ((side1 == side2 && side2 != side3) || (side2 == side3 && side3 != side1)) {
			// two sides are equal
			return ISOSCELES;
		} else if (side1 != side2 && side2 != side3) {
			// none of the sides are equal
			return SCALENE;
		} else if (side1 >= (side2 + side3) ||
					side3 >= (side2 + side1) || 
					side2 >= (side1 + side3)) {
			// if one side is less than sum of other two sides																
			return INVALID;
		}
		return INVALID;
	}
} 