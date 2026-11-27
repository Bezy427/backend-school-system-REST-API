
package com.bezy.school_system.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;

@Data
public class RegisterLectureRequest {

    @NotNull(message = "Start time must be provided!")
    private LocalTime startTime;

    @NotNull(message = "End time must be provided!")
    private LocalTime endTime;

    @NotBlank(message = "Subject name must be provided!")
    private String subjectName;

    @NotNull(message = "Teacher must be selected!")
    private Long teacherId;

    @NotBlank(message = "Location must be provided!")
    private String location;
}
