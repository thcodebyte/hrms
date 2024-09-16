package com.hrms.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InterviewMode {

    ONLINE("线上"),
    OFFLINE("线下");

    private final String description;
}
