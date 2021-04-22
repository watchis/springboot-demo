package io.github.watchis.RobotIconService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RobotIconServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotIconServiceApplication.class, args);
	}

}
