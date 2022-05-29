package com.jobpost.software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EntityScan("com.jobpost.software")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class JobPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobPostApplication.class, args);
	}

}
