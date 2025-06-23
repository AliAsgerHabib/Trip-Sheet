package org.ashara.chennai.transport.tripsheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TripSheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripSheetApplication.class, args);
	}

}
