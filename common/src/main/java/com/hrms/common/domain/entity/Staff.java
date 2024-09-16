package com.hrms.common.domain.entity;

import com.hrms.common.utils.SnowflakeIdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.*;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 员工
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SoftDelete(strategy = SoftDeleteType.DELETED)
public class Staff extends BaseEntity{

    /**
     * 工号
     */
    @Column(nullable = false, unique = true)
    private Long sid;

    private String name;

    private String avatar;

    private String gender;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    private String address;

    private LocalDate birthday;

    @Column(nullable = false, columnDefinition = "date")
    @Builder.Default
    private LocalDate entryDate = LocalDate.now();

    @Column(columnDefinition = "date")
    private LocalDate exitDate;

    @Column(nullable = false)
    private BigDecimal baseSalary;

    /**
     * 是否已绑定账号
     */
    @Column(nullable = false)
    private boolean bind = false;

    @ManyToOne
    private Job job;

    @PrePersist
    public void prePersist() {
        if (this.sid == 0) {
            this.sid = SnowflakeIdGenerator.generateId();
        }
    }
}
