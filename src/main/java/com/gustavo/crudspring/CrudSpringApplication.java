package com.gustavo.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gustavo.crudspring.model.Course;
import com.gustavo.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course c1 = new Course();
			c1.setName("Angular");
			c1.setCategory("Front-end");
			courseRepository.save(c1);

			Course c2 = new Course();
			c2.setName("Spring");
			c2.setCategory("Back-end");
			courseRepository.save(c2);
		};
	}
}
