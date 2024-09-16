package com.hrms.recruitment.service;

import cn.hutool.core.bean.BeanUtil;
import com.hrms.common.domain.dto.CJobDto;
import com.hrms.common.domain.entity.Job;
import com.hrms.common.domain.vo.JobVo;
import com.hrms.common.exception.InvalidOperationException;
import com.hrms.recruitment.repository.JobRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Resource
    private JobRepository jobRepository;

    public JobVo createJob(CJobDto dto) {
        Job job = BeanUtil.copyProperties(dto, Job.class);
        return convertToJobVo(jobRepository.save(job));
    }
    private JobVo convertToJobVo(Job job) {
        JobVo jobVo = BeanUtil.copyProperties(job, JobVo.class);
        return jobVo;
    }

    public List<?> getJobList() {
        return jobRepository.findAll().stream()
                .map(this::convertToJobVo)
                .toList();
    }

    public JobVo updateJob(long jobId, CJobDto dto) {
        Job updated = jobRepository.update(jobId, dto);
        return convertToJobVo(updated);
    }

    public Job getById(long jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(InvalidOperationException::new);
    }
}
