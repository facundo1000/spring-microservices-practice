package dev.fmartinez.microservicecourse.repositories;

import dev.fmartinez.microservicecourse.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
