package com.hrms.common.domain.entity;

import com.hrms.common.enums.EduLevel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

/**
 * 职位招聘信息实体类
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobPost extends BaseEntity{

    @ManyToOne
    private Job job;

    private String title;

    private String location;

    private String salaryRange;

    private String experienceRange;

    private EduLevel educationLevel;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    private boolean internship;

    private String internshipDuration;

    @Builder.Default
    private LocalDate postDate = LocalDate.now();

    @Builder.Default
    private boolean active = true;

}
