package dev.fmartinez.microservicestudent.services.impl;

import dev.fmartinez.microservicestudent.models.Student;
import dev.fmartinez.microservicestudent.repositories.StudentRepository;
import dev.fmartinez.microservicestudent.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public Student findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        repo.save(student);
    }

    @Override
    public void deleteById(Long id) {
        Student student = this.findById(id);
        student.setActive(false);
        repo.save(student);
    }

    @Override
    public List<Student> findByCourseId(Long courseId) {
        return repo.findAllByCourseId(courseId).orElseThrow();
    }
}
