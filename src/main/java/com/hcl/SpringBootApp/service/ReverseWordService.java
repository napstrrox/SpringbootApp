package com.hcl.SpringBootApp.service;

import org.springframework.stereotype.Component;

import com.hcl.SpringBootApp.model.Message;

@Component
public class ReverseWordService {
	public Message reverseWord(String str){
		
		if(str==null || str.isEmpty()) {
			throw new IllegalArgumentException ("Input should not be empty or null");
		}
		
	    String words[]=str.split("\\s");  
	    String reverseWord="";  
	    for(String w:words){  
	        StringBuilder sb=new StringBuilder(w);  
	        sb.reverse();  
	        reverseWord+=sb.toString()+" ";  
	    }  
	    
	    Message m1=new Message();
	    m1.setMessage(reverseWord);
	    return m1;  
	}  
}
