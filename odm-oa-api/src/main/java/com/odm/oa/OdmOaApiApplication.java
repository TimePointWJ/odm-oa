package com.odm.oa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.odm.oa.dao.mapper")
@EnableSwagger2
public class OdmOaApiApplication {
	
	private static Logger logger = LogManager.getLogger(OdmOaApiApplication.class);

	public static void main(String[] args) {
		logger.info("------------SpringBoot开始启动------------------");
		SpringApplication.run(OdmOaApiApplication.class, args);
		logger.info("------------SpringBoot启动完成------------------");
	}
}
