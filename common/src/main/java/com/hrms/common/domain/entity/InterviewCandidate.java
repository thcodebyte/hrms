package com.hrms.common.domain.entity;

import com.hrms.common.enums.InterviewStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class InterviewCandidate extends BaseEntity{

    @ManyToOne
    @JoinColumn(nullable = false)
    private Interview interview;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Candidate candidate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InterviewStatus status;
}
