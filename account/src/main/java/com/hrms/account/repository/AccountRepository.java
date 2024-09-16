package com.hrms.account.repository;

import com.hrms.common.domain.entity.Account;
import com.hrms.common.domain.repository.IBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends IBaseRepository<Account> {
}
