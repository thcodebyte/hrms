package com.hrms.recruitment.repository;

import com.hrms.common.domain.entity.Resume;
import com.hrms.common.domain.repository.IBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends IBaseRepository<Resume> {
}
