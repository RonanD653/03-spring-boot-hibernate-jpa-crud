package com.UdemySpringBoot.__spring_boot_hibernate_jpa_crud.dao;

import com.UdemySpringBoot.__spring_boot_hibernate_jpa_crud.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);
}
