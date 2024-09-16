package com.hrms.common.domain.repository;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.hrms.common.exception.InvalidOperationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    default T update(long id, Object tObject) {
        T t = this.findById(id)
                .orElseThrow(InvalidOperationException::new);
        BeanUtil.copyProperties(tObject, t, CopyOptions.create().setIgnoreNullValue(true));
        return this.save(t);
    }
}
