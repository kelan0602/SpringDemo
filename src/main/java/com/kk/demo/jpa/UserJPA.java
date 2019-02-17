package com.kk.demo.jpa;

import com.kk.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends
        JpaRepository<UserEntity, Long>, //SpringDataJPA提供的简单数据操作接口  实体类 ，主键 参数
        JpaSpecificationExecutor<UserEntity>, //SpringDataJPA提供的复杂查询接口
        Serializable {

}
