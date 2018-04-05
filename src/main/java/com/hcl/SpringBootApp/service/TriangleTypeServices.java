package com.hcl.SpringBootApp.service;

import org.springframework.stereotype.Component;

import com.hcl.SpringBootApp.model.Triangle;

@Component
public class TriangleTypeServices {
	public Triangle getTringleType(int side1, int side2, int side3) {

		Triangle triangle = new Triangle();
		if ((side1 + side2 > side3)) {

			if ((side1 == side2) && (side2 == side3)) {

				triangle.setA(side1);
				triangle.setB(side2);
				triangle.setC(side3);
				triangle.setType("An Equilateral Triangle");
				return triangle;

			}

			else if ((side1 == side2) & (side2 != side3) || (side2 == side3) & (side3 != side1)) {
				
				triangle.setA(side1);
				triangle.setB(side2);
				triangle.setC(side3);
				triangle.setType("An Isosceles Triangle.");
				return triangle;
			}

			else if ((side1 != side2) & (side2 != side3)) {
				triangle.setA(side1);
				triangle.setB(side2);
				triangle.setC(side3);
				triangle.setType("A Scalene Triangle.");
				return triangle;
			}

		} else {
			triangle.setType("This Triangle is NOT possible.");
		}
		return triangle;

	}
} 
