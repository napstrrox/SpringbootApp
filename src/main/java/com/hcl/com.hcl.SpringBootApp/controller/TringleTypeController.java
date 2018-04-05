package com.hcl.SpringBootApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.SpringBootApp.model.Triangle;
import com.hcl.SpringBootApp.service.TriangleTypeServices;

@RestController
@RequestMapping("/api")
public class TringleTypeController {

	@Autowired
	TriangleTypeServices services;
	
	@RequestMapping(value="/TriangleType", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> triangleType (@RequestParam(value="a") int a,@RequestParam(value="b") int b,@RequestParam(value="c") int c) 
	{
		Triangle result=new Triangle();
		result=services.getTringleType(a, b, c);
		return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.noCache()).header("Pragma", "no-cache").body(result);
	}
}
