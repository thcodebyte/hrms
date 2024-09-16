package com.hrms.common.domain.repository;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.hrms.common.exception.InvalidOperationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    /**
     * 根据主键ID更新并保存实体
     *
     * @param id 更新实体的主键
     * @param tObject 更新实体的对象
     * @return 更新后的实体
     */
    default T update(long id, Object tObject) {
        T t = this.findById(id)
                .orElseThrow(InvalidOperationException::new);
        BeanUtil.copyProperties(tObject, t, CopyOptions.create().setIgnoreNullValue(true));
        return this.save(t);
    }
}
