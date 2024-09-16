package com.hrms.recruitment.service;

import cn.hutool.core.bean.BeanUtil;
import com.hrms.common.domain.dto.CResumeDto;
import com.hrms.common.domain.entity.JobPost;
import com.hrms.common.domain.entity.Resume;
import com.hrms.common.enums.Gender;
import com.hrms.common.exception.InvalidOperationException;
import com.hrms.recruitment.repository.ResumeRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {
    @Resource
    private ResumeRepository resumeRepository;
    @Resource
    private JobPostService jobPostService;
    @Resource
    private CandidateService candidateService;

    public Resume createResume(CResumeDto dto) {
        long jobPostId = dto.getJobPostId();
        JobPost jobPost = jobPostService.getById(jobPostId);

        Resume resume = BeanUtil.copyProperties(dto, Resume.class);
        resume.setJobPost(jobPost);

        Resume saved = resumeRepository.save(resume);
        return saved;
    }

    public List<?> getResumeList() {
        return resumeRepository.findAll();
    }

    public Resume getById(Long id) {
        return resumeRepository.findById(id)
                .orElseThrow(InvalidOperationException::new);
    }

    public void passResumes(List<Long> resumeIds) {
        resumeRepository.saveAll(resumeRepository.findAllById(resumeIds).stream().peek(resume -> {
            resume.setPassed(true);
            resumeRepository.save(resume);
        }).toList());

        candidateService.createCandidates(resumeIds);
    }
}
