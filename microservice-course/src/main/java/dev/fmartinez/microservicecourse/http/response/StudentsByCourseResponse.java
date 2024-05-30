package dev.fmartinez.microservicecourse.http.response;

import dev.fmartinez.microservicecourse.dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentsByCourseResponse {
    private String courseName;
    private String teacher;
    private List<StudentDto> studentsList;
}
