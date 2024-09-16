package com.hrms.web.controller;

import com.hrms.common.domain.dto.CJobDto;
import com.hrms.common.domain.vo.JobVo;
import com.hrms.common.result.R;
import com.hrms.recruitment.service.JobService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobController {
    @Resource
    private JobService jobService;

    @PostMapping
    public R<?> createJob(@RequestBody CJobDto dto) {
        JobVo jobVo = jobService.createJob(dto);
        return R.created(jobVo);
    }

    @GetMapping
    public R<?> getJobList() {
        List<?> jobList = jobService.getJobList();
        return R.ok(jobList);
    }

    @PatchMapping("/{id}")
    public R<?> updateJob(@PathVariable("id") long id,
                          @RequestBody CJobDto dto) {
        JobVo jobVo = jobService.updateJob(id, dto);
        return R.updated(jobVo);
    }
}
