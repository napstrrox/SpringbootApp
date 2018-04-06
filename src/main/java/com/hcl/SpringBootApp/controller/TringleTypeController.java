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
import com.hcl.SpringBootApp.service.TriangleTypeServices;

@RestController
@RequestMapping("/api")
public class TringleTypeController {

	@Autowired
	TriangleTypeServices services;

	@RequestMapping(value = "/TriangleType", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getTriangleType(@RequestParam Object a, @RequestParam Object b, @RequestParam Object c) {

		try {
			Integer itsA = new Integer(a.toString());
			Integer itsB = new Integer(b.toString());
			Integer itsC = new Integer(c.toString());

			if (itsA < 0 || itsB < 0 || itsC < 0) {
				throw new InvalidRequestException("Invalid Input : Null Or Negative input");
			}
		} catch (NumberFormatException e) {
			throw new InvalidRequestException("Invalid Input: Invalid type");
		}
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(TriangleTypeServices.findTriangleType(new Integer(a.toString()), new Integer(b.toString()),
						new Integer(c.toString())));
	}
}