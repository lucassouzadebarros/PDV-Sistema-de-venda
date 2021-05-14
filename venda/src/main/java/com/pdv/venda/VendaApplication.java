package com.pdv.venda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class VendaApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(VendaApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}
	
	
	public void addCorsMapping(CorsRegistry registry) {
		
		registry.addMapping("/venda/**")
		.allowedMethods("*")
		.allowedOrigins("*");
		
	}

}
