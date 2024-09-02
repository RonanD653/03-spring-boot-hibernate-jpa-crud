package com.UdemySpringBoot.__spring_boot_hibernate_jpa_crud;

import com.UdemySpringBoot.__spring_boot_hibernate_jpa_crud.dao.StudentDAO;
import com.UdemySpringBoot.__spring_boot_hibernate_jpa_crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Ronan", "Donnelly", "Ronan@mail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generate ID: " + tempStudent.getId());
	}
}
