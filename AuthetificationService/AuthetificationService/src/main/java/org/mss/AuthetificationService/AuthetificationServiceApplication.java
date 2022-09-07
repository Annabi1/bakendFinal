package org.mss.AuthetificationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@EnableDiscoveryClient
@RequestMapping("/auth")
@SpringBootApplication
public class AuthetificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthetificationServiceApplication.class, args);
	}
	@GetMapping("/")
    public  String getNameService() {
    return "Authentification  service";
}
	
}
