package com.hcl.SpringBootApp.service;

import org.springframework.stereotype.Component;

@Component
public class ReverseWordService {
	public static String getReverseWord(String str) {
		String words[] = str.split("\\s");
		String reverseWord = "";
		for (String w : words) {
			StringBuilder sb = new StringBuilder(w);
			sb.reverse();
			reverseWord += sb.toString() + " ";
		}
		return reverseWord;
	}
}
