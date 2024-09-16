package com.hrms.web.initial;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.hrms.account.repository.AccountRepository;
import com.hrms.account.service.AccountService;
import com.hrms.common.domain.entity.Account;
import com.hrms.common.domain.entity.Job;
import com.hrms.common.domain.entity.JobPost;
import com.hrms.common.domain.entity.Resume;
import com.hrms.common.enums.EduLevel;
import com.hrms.common.enums.Gender;
import com.hrms.common.enums.Role;
import com.hrms.recruitment.repository.JobPostRepository;
import com.hrms.recruitment.repository.JobRepository;
import com.hrms.recruitment.repository.ResumeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class DBInitializer implements CommandLineRunner {
    @Resource
    private AccountRepository accountRepository;
    @Resource
    private JobRepository jobRepository;
    @Resource
    private JobPostRepository jobPostRepository;
    @Resource
    private ResumeRepository resumeRepository;

    @Value("${default.admin.username}")
    private String username;
    @Value("${default.admin.password}")
    private String password;
    @Override
    public void run(String... args) throws Exception {
        if(accountRepository.count() == 0) {
            Account admin = Account.builder()
                    .username(username)
                    .password(SaSecureUtil.md5(password))
                    .role(Role.ADMIN)
                    .build();
            accountRepository.save(admin);
        }

        Job job = null;
        if(jobRepository.count() == 0) {
            job = Job.builder()
                    .name("Java开发工程师")
                    .description("负责Java开发工作，包括但不限于Java基础开发、框架开发、中间件开发、性能调优等。")
                    .build();
            jobRepository.save(job);
        }

        JobPost jobPost = null;
        if(jobPostRepository.count() == 0) {
            jobPost = JobPost.builder()
                    .job(job)
                    .title("Java开发工程师")
                    .description("负责Java开发工作，包括但不限于Java基础开发、框架开发、中间件开发、性能调优等。")
                    .location("北京")
                    .salaryRange("4k-6k")
                    .experienceRange("1-2年")
                    .educationLevel(EduLevel.UNDERGRADUATE)
                    .internship(true)
                    .internshipDuration("3-6个月")
                    .postDate(LocalDate.now())
                    .build();
            jobPostRepository.save(jobPost);
        }

        if(resumeRepository.count() == 0) {
            Resume resume = Resume.builder()
                    .jobPost(jobPost)
                    .name("张三")
                    .avatar("https://www.gravatar.com/avatar/0000000000?d=mp")
                    .gender(Gender.MALE)
                    .email("1976412750@qq.com")
                    .phone("13800138000")
                    .graduation("中山大学")
                    .experienceRange(null)
                    .experience(null)
                    .skills("Java开发")
                    .language("德语")
                    .expectedSalaryRange("3K-5K")
                    .appliedAt(new Date())
                    .build();
            resumeRepository.save(resume);
        }
    }
}
