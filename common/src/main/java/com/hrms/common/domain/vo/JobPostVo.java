package com.hrms.common.domain.vo;

import com.hrms.common.enums.EduLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class JobPostVo extends BaseVo{

    private JobVo job;

    private String title;

    private String location;

    private String salaryRange;

    private String experienceRange;

    private EduLevel educationLevel;

    private String requirements;

    private String description;

    private boolean internship;

    private String internshipDuration;

    private LocalDate postDate = LocalDate.now();

    private LocalDate deadline;

    private boolean active = true;
}
