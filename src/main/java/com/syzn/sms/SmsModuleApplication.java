package com.syzn.sms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author JianTao Li
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.syzn.sms.mapper")
public class SmsModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsModuleApplication.class, args);
	}

}
