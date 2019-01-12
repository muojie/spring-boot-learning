package org.kfit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.web.bind.annotation.RestController
@RestController
public class Hello3Controller {
	
	//import org.springframework.web.bind.annotation.RequestMapping
	@RequestMapping("/helo33")
	public String hello33(){
		return "hello33";
	}
	
}
