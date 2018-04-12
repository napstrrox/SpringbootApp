package com.hcl.SpringBootApp.controller;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.SpringBootApp.model.MakeOneArray;
import com.hcl.SpringBootApp.service.MakeOneArrayService;

@RestController
@RequestMapping("/api")
public class MakeOneArrayController {
	
	@RequestMapping(value="/makeonearray", method=RequestMethod.POST)
	public ResponseEntity<Object> getOneArray(@RequestBody MakeOneArray oneArray) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.cacheControl(CacheControl.noCache())
				.header("Pragma", "no-cache")
				.body(MakeOneArrayService.getOneArray(oneArray));
	}
}