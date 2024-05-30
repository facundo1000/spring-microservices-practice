package dev.fmartinez.microservicecourse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDto {
    private String name;
    private String lastName;
    private String email;
    private Long courseId;
    private Boolean active;
}
