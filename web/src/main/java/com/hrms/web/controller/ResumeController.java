package com.hrms.web.controller;

import com.hrms.common.domain.dto.CResumeDto;
import com.hrms.common.domain.entity.Resume;
import com.hrms.common.result.R;
import com.hrms.recruitment.service.ResumeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 简历控制器
 */
@RestController
@RequestMapping("/api/resume")
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @PostMapping
    public R<?> createResume(@RequestBody CResumeDto dto) {
        Resume resume = resumeService.createResume(dto);
        return R.created("投递成功", resume);
    }
    @GetMapping
    public R<?> getResumeList() {
        List<?> resumeList = resumeService.getResumeList();
        return R.ok(resumeList);
    }
    @PostMapping("/pass")
    public R<?> passResumes(@RequestBody List<Long> resumeIds) {
        resumeService.passResumes(resumeIds);
        return R.ok("审核通过");
    }
}
