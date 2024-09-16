package com.hrms.common.domain.dto;


import com.hrms.common.enums.Gender;
import lombok.Data;


@Data
public class CResumeDto {

    private long jobPostId;

    private String name;

    private String avatar;

    private Gender gender;

    private String email;

    private String phone;

    private String graduation;

    private String experienceRange;

    private String experience;

    private String skills;

    private String language;

    private String expectedSalaryRange;
}
