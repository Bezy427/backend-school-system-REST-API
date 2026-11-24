package com.bezy.school_system.dtos;

import com.bezy.school_system.entities.Student;
import com.bezy.school_system.entities.User;
import lombok.Data;

import java.util.Date;

@Data
public class PrincipalDto {
    private Long id;
    private String officeLocation;
    private Date startDate;
    private User user_id;
    private Student student_id;
}
