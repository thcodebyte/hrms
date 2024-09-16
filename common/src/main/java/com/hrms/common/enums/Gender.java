package com.hrms.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender implements IBaseEnum<Gender>{

    MALE("男"),
    FEMALE("女"),
    OTHER("其他");

    private final String text;

    public static String text(Gender gender) {
        return gender.convertToText(gender);
    }

    @Override
    public Class<? extends Gender> enumClass() {
        return this.getClass();
    }
}
