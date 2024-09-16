package com.hrms.common.domain.entity;

import com.hrms.common.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 简历实体类
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Resume extends BaseEntity{

    @ManyToOne
    private JobPost jobPost;

    private String name;

    private String avatar;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    private String phone;

    private String graduation;

    private String experienceRange;

    private String experience;

    private String skills;

    private String language;

    private String expectedSalaryRange;

    @Builder.Default
    private Date appliedAt = new Date();

    private boolean passed = false;
}
