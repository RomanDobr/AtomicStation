package org.javaacademy.AtomicStation;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class Runner {

	public static void main(String[] args)  {
		ApplicationContext context = SpringApplication.run(Runner.class, args);
		NuclearStation station = context.getBean(NuclearStation.class);
		station.start(3);
	}
}
