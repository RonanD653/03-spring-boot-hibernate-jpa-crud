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
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");

		Student tempStudent = new Student("Daffy", "Duck", "Daffy@mail.com");
		studentDAO.save(tempStudent);

		int id = tempStudent.getId();
		System.out.println("Saved student. Genertated Id: " + id);

		System.out.println("Retrieving student with id " + id);
		Student myStudent = studentDAO.findById(id);

		System.out.println("Student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 new student object...");
		Student tempStudent1 = new Student("john", "Doe", "John@mail.com");
		Student tempStudent2 = new Student("Mary", "Public", "Mary@mail.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "Bonita@mail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved student. Generate ID: " + tempStudent1.getId());
		System.out.println("Saved student. Generate ID: " + tempStudent2.getId());
		System.out.println("Saved student. Generate ID: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Ronan", "Donnelly", "Ronan@mail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generate ID: " + tempStudent.getId());
	}
}
