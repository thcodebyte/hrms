package com.hrms.recruitment.service;

import cn.hutool.core.bean.BeanUtil;
import com.hrms.common.domain.entity.Candidate;
import com.hrms.common.domain.entity.Resume;
import com.hrms.recruitment.repository.CandidateRepository;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    @Resource
    private CandidateRepository candidateRepository;
    @Resource
    @Lazy
    private ResumeService resumeService;

    public List<Candidate> createCandidates(List<Long> resumeIds) {
        return candidateRepository.saveAll(resumeIds.stream().map(id -> {
            Resume resume = resumeService.getById(id);
            Candidate candidate = BeanUtil.copyProperties(resume, Candidate.class);
            candidate.setResume(resume);
            return candidate;
        }).toList());
    }
}
