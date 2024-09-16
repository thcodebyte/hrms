package com.hrms.common.domain.entity;

import com.hrms.common.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 候选人实体类
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Candidate extends BaseEntity{

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    private String phone;

    @OneToOne
    private Resume resume;

    @ManyToOne
    private JobPost jobPost;

    private boolean passed = false;
}
