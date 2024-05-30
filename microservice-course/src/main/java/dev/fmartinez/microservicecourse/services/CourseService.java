package dev.fmartinez.microservicecourse.services;

import dev.fmartinez.microservicecourse.http.response.StudentsByCourseResponse;
import dev.fmartinez.microservicecourse.models.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    void deleteById(Long id);

    StudentsByCourseResponse findStudentsByIdCourse(Long id);
}
