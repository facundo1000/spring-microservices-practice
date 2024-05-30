package dev.fmartinez.microservicecourse.services.impl;

import dev.fmartinez.microservicecourse.client.StudentClient;
import dev.fmartinez.microservicecourse.dto.StudentDto;
import dev.fmartinez.microservicecourse.http.response.StudentsByCourseResponse;
import dev.fmartinez.microservicecourse.models.Course;
import dev.fmartinez.microservicecourse.repositories.CourseRepository;
import dev.fmartinez.microservicecourse.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repo;
    private final StudentClient studentClient; //Inyectar el cliente

    @Override
    public List<Course> findAll() {
        return repo.findAll();
    }

    @Override
    public Course findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        repo.save(course);
    }

    @Override
    public void deleteById(Long id) {
        Course course = repo.findById(id).orElseThrow();
        course.setActive(false);
        repo.save(course);
    }

    @Override
    public StudentsByCourseResponse findStudentsByIdCourse(Long id) {

        //Consultar el curso
        Course course = repo.findById(id).orElseThrow();

        //Consultar los estudiantes del curso
        List<StudentDto> students = studentClient.findAllStudentsByCourse(id);

        return StudentsByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentsList(students)
                .build();
    }
}
