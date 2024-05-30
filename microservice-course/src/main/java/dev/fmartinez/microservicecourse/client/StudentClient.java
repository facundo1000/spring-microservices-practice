package dev.fmartinez.microservicecourse.client;

import dev.fmartinez.microservicecourse.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-student")
public interface StudentClient {

    @GetMapping("/api/students/search-by-course/{id}")
    List<StudentDto> findAllStudentsByCourse(@PathVariable Long id);
}
