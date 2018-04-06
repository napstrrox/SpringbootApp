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

import com.hcl.SpringBootApp.exception.InvalidRequestException;
import com.hcl.SpringBootApp.service.ReverseWordService;

@RestController
@RequestMapping("/api")
public class ReverseWordController {

	@Autowired
	ReverseWordService service;

	@RequestMapping(value = "/ReverseWords", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getReverseWords(@RequestParam String sentence) {
		if (sentence==null||sentence.isEmpty()) {
			throw new InvalidRequestException("Input is null or Empty.");
		}
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(ReverseWordService.getReverseWord(sentence));
	}
}
