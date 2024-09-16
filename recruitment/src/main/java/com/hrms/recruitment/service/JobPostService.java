package com.hrms.recruitment.service;

import cn.hutool.core.bean.BeanUtil;
import com.hrms.common.domain.dto.CJobPostDto;
import com.hrms.common.domain.entity.Job;
import com.hrms.common.domain.entity.JobPost;
import com.hrms.common.domain.vo.JobPostVo;
import com.hrms.common.exception.InvalidOperationException;
import com.hrms.recruitment.repository.JobPostRepository;
import com.hrms.recruitment.repository.JobRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostService {
    @Resource
    private JobPostRepository jobPostRepository;
    @Resource
    private JobService jobService;

    public JobPostVo publishJobPost(CJobPostDto dto) {
        JobPost jobPost = BeanUtil.copyProperties(dto, JobPost.class);
        Job job = jobService.getById(dto.getJobId());

        jobPost.setJob(job);
        JobPost saved = jobPostRepository.save(jobPost);
        return convertToJobVo(saved);
    }

    private JobPostVo convertToJobVo(JobPost jobPost) {
        JobPostVo jobPostVo = BeanUtil.copyProperties(jobPost, JobPostVo.class);
        return jobPostVo;
    }

    public List<?> getJobPostList() {
        return jobPostRepository.findAll().stream()
                .map(this::convertToJobVo)
                .toList();
    }

    public JobPostVo updateJobPost(long jobPostId, CJobPostDto dto) {
        JobPost updated = jobPostRepository.update(jobPostId, dto);
        return convertToJobVo(updated);
    }

    public JobPost getById(long jobPostId) {
        return jobPostRepository.findById(jobPostId)
                .orElseThrow(InvalidOperationException::new);
    }

    public boolean toggleActive(long id) {
        JobPost jobPost = jobPostRepository.findById(id)
               .orElseThrow(InvalidOperationException::new);
        jobPost.setActive(!jobPost.isActive());
        JobPost saved = jobPostRepository.save(jobPost);
        return saved.isActive();
    }
}
