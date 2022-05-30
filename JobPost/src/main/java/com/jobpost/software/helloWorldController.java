package com.jobpost.software;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jobpost.software.bean.HelloWorldBean;

@RestController
public class helloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	public String helloWorld() {
		return "hellow world";
	}
	
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hellow world");
	}
	
	@GetMapping(path="/hello-world-bean-para/{name}")
	public HelloWorldBean helloWorldParaBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("hellow world%s", name));
	}
	
    
    @GetMapping("/hello-world-i18n")
    public String helloWorldi18n(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
   	 int test = 1;
   	 
   	 
   	 return messageSource.getMessage("good.morning.message",null,"Missing Label", locale);
//   	 int test2 = 2;
//        return "SpringBoot,HelloWord22!";
    }
}
