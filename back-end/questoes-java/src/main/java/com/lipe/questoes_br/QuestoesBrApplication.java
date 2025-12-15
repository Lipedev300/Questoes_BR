package com.lipe.questoes_br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lipe.questoes_br")
public class QuestoesBrApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestoesBrApplication.class, args);
	}
}