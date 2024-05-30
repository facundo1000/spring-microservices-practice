package dev.fmartinez.microservicestudent.controllers;

import dev.fmartinez.microservicestudent.models.Student;
import dev.fmartinez.microservicestudent.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }


    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        service.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/search-by-course/{id}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long id) {
        return new ResponseEntity<>(service.findByCourseId(id), HttpStatus.OK);
    }
}
