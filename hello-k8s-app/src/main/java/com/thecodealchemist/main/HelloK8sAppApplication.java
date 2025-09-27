package com.thecodealchemist.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloK8sAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloK8sAppApplication.class, args);
	}

}

@RestController
@RequestMapping("/hello")
class HelloController {

    @GetMapping
    public String hello() {
        return "Hello k8s";
    }
}

