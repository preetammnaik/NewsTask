package com.news.task;

import com.news.task.controller.NewsController;
import com.news.task.model.News;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication

public class TaskApplication {
		public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}
