package dev.fmartinez.microservicecourse.services.impl;

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
}
