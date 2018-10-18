package com.odm.oa.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author: 
 * 
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

	private Logger logger = LogManager.getLogger(this.getClass());
	
    @RequestMapping("/test")
    public String hello() {
    	logger.info("------------SpringBoot进入controller方法------------------");
        return "Hello Spring Boot!";
    }
}