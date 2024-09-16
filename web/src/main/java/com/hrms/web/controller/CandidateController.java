package com.hrms.web.controller;

import com.hrms.common.result.R;
import com.hrms.recruitment.service.CandidateService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
    @Resource
    private CandidateService candidateService;
    @PostMapping
    public R<?> createCandidates(@RequestBody List<Long> resumeIds) {
        List<?> candidates = candidateService.createCandidates(resumeIds);
        return R.created(candidates);
    }

}
