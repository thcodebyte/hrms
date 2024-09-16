package com.hrms.common.domain.dto;

import com.hrms.common.enums.EduLevel;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class CJobPostDto {

    private long jobId;

    private String title;

    private String location;

    private String salaryRange;

    private String experienceRange;

    private EduLevel educationLevel;

    private String requirements;

    private String description;

    private boolean internship;

    private String internshipDuration;

}
