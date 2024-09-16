package com.hrms.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EduLevel {

    NO_REQUIREMENT("无要求"),
    SENIOR("高中"),
    UNDERGRADUATE("本科"),
    POSTGRADUATE("研究生");

    private final String description;
}
