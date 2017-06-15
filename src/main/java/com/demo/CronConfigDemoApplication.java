package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableScheduling
public class CronConfigDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CronConfigDemoApplication.class, args);
	}
	
	@Component
	public class Scheduler {
	    private Long count = Long.MIN_VALUE;
	    
	    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	    @Scheduled(cron = "${device.poll.cron:0 0/1 * * * *}")
	    public void log() {
	        logger.info("{}", count++); 
	    }
	}
}


