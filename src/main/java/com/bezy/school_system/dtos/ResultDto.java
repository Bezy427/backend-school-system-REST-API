package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Status;
import lombok.Data;

@Data
public class ResultDto {
    private Long id;
    private String marks;
    private String grade;
    private Status status;
}
