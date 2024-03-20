package ru.mccormick.ipa.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

	@PostMapping("/hello")
	public String hello(@RequestBody String request) throws UnsupportedEncodingException {
		String decode = decode(request);
		
		System.out.println(decode);
		
		return decode;
	}
	
//	@GetMapping("/history/{id}")
//	public int history(@PathVariable("id") int id) {
//		return id;
//	}
	
	private String decode(String value) throws UnsupportedEncodingException {
		return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
	}
}
