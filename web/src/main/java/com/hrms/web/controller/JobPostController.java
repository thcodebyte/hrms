package com.hrms.web.controller;

import com.hrms.common.domain.dto.CJobPostDto;
import com.hrms.common.domain.vo.JobPostVo;
import com.hrms.common.result.R;
import com.hrms.recruitment.service.JobPostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-post")
public class JobPostController {
    @Resource
    private JobPostService jobPostService;
    @PostMapping
    public R<?> publishJobPost(@RequestBody CJobPostDto dto) {
        JobPostVo jobPostVo = jobPostService.publishJobPost(dto);
        return R.created(jobPostVo);
    }
    @GetMapping
    public R<?> getJobPostList() {
        List<?> jobPostList = jobPostService.getJobPostList();
        return R.ok(jobPostList);
    }
    @PostMapping("/{id}")
    public R<?> updateJobPost(@PathVariable("id") long id,
                              @RequestBody CJobPostDto dto) {
        JobPostVo jobPostVo = jobPostService.updateJobPost(id, dto);
        return R.updated(jobPostVo);
    }
}
