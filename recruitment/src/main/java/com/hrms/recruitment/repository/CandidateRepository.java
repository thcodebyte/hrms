package com.hrms.recruitment.repository;

import com.hrms.common.domain.entity.Candidate;
import com.hrms.common.domain.repository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends IBaseRepository<Candidate> {
}
