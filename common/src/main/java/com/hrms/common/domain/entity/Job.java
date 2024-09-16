package com.hrms.common.domain.entity;

import jakarta.persistence.Entity;
import lombok.*;

/**
 * 职位
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Job extends BaseEntity{

    private String name;

    private String description;

}
