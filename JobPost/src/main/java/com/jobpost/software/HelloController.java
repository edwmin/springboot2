package com.jobpost.software;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // 標註為Spring組件
 public class HelloController {
     
     @RequestMapping("/helloSpringBoot")  // 標註訪問地址
     @ResponseBody    // 標註返回結果位JSON串
     public String helloSpringBoot() {
    	 int test = 1;
    	 
    	 int test2 = 2;
         return "SpringBoot,HelloWord22222!team commmite not ";
     }

 }