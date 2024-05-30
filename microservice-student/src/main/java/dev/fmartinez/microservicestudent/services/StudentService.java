package dev.fmartinez.microservicestudent.services;

import dev.fmartinez.microservicestudent.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    void deleteById(Long id);

    List<Student> findByCourseId(Long courseId);

}
