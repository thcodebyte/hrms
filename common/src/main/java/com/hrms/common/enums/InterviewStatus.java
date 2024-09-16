package com.hrms.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InterviewStatus {

    PENDING("待面试"),
    NOTIFIED("已通知面试"),
    APPROVED("通过面试"),
    REJECTED("未通过面试");

    private final String description;
}
