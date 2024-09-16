package com.hrms.common.enums;

import com.hrms.common.exception.InvalidParameterException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    ADMIN("管理员", "admin"),

    USER("普通用户", "user"),

    MANAGER("经理", "manager"),

    HR("人事", "hr"),

    FINANCE("财务", "finance"),

    STAFF("员工", "staff");

    private final String description;
    private final String symbol;

    public static String description(Role role) throws InvalidParameterException {
        if(role == null) {
            throw new InvalidParameterException();
        }
        return role.getDescription();
    }
    public static String symbol(Role role) {
        return role.getSymbol();
    }
}
