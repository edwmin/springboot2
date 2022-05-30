package com.jobpost.software.filtering;



import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.jobpost.software.bean.HelloWorldBean;
import com.jobpost.software.bean.SomeBean;

@RestController
public class FilteringController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/filtering")
	public List<SomeBean> retrieveSomeBean() {
		return Arrays.asList(new SomeBean("v1","v2","v3"),new SomeBean("v12","v22","v32")) ;
	}

	@GetMapping("/filtering2")
	public MappingJacksonValue dynamicRetrieveSomeBean() {
		SomeBean someBean = new SomeBean("v12","v22","v32");
		
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		
		mapping.setFilters(filters);
		
		return mapping;
		
	}

	@GetMapping("/filtering3")
	public MappingJacksonValue retrieveSomeBean2() {
		
		
		List<SomeBean> beanList = Arrays.asList(new SomeBean("v1","v2","v3"),new SomeBean("v12","v22","v32")) ;
		 
			
			SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("field1");
			
			FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
			
			MappingJacksonValue mapping = new MappingJacksonValue(beanList);
			
			mapping.setFilters(filters);
			
			return mapping;
			
		 
	}
	
	
	
}