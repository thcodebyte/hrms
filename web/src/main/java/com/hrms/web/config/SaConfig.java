package com.hrms.web.config;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaConfig implements WebMvcConfigurer {
    @Bean
    @Primary
    public SaTokenConfig saTokenConfig() {
        SaTokenConfig config = new SaTokenConfig();
        config.setTokenName("hrms");
        config.setTimeout(30 * 24 * 60 * 60);
        config.setActiveTimeout(-1);
        config.setIsConcurrent(true);
        config.setIsShare(true);
        config.setTokenStyle("uuid");
        config.setIsLog(false);
        return config;
    }
    @Bean
    public SaServletFilter saServletFilter() {
        return new SaServletFilter()
                .setAuth(a -> SaManager.getLog().info("请求路径: {}, 提交令牌: {}",
                        SaHolder.getRequest().getRequestPath(), StpUtil.getTokenValue()))
                .setError(e -> SaResult.error(e.getMessage()))
                .setBeforeAuth(a -> {
                    SaRequest request = SaHolder.getRequest();
                    String origin = request.getHeader("Origin");
                    if(origin== null) {
                        origin = request.getHeader("Referer");
                    }
                    SaHolder.getResponse()
                            .setHeader("Access-Control-Allow-Origin", origin)
                            .setHeader("Access-Control-Allow-Credentials", "true")
                            .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PATCH")
                            .setHeader("Access-Control-Allow-Headers", "Content-Type, X-Requested-With, X-CSRF-Token, Authorization")
                            .setHeader("Access-Control-Max-Age", "3600");
                    SaRouter.match(SaHttpMethod.OPTIONS)
                            .back();
                });
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(i -> {
        }))
                .addPathPatterns("/**");
    }
}
