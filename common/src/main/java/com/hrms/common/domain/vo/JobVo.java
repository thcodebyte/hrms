package com.hrms.common.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class JobVo extends BaseVo{
    private String name;
    private String description;
}
