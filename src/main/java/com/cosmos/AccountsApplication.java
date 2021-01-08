package com.cosmos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@EnableOAuth2Sso
@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class AccountsApplication {

	

	public static void main(String[] args) {
		
		SpringApplication.run(AccountsApplication.class, args);
	}

}
