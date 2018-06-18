package com.forum.myforum;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Indexalice
 * @date 2018/4/24 22:09
 */
@SpringBootApplication
@EnableTransactionManagement
public class MyforumApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyforumApplication.class, args);
	}

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(Application.class);
  }
}
