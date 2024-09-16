package com.hrms.common.domain.entity;

import com.hrms.common.enums.InterviewMode;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Interview extends BaseEntity{

    @OneToMany(mappedBy = "interview", cascade = CascadeType.ALL)
    private List<InterviewCandidate> interviewCandidates;

    @ManyToOne
    private JobPost jobPost;

    private Date interviewDate;

    @ManyToOne
    private Staff interviewer;

    @Enumerated(EnumType.STRING)
    private InterviewMode mode;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String feedback;
}
