package com.stydy.study1.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stydy.study1.model.entity.User;

/**
 * 继承 JpaRepository 后，基础的增删改查、分页排序都自动具备，
 * 不需要写实现类；方法名按 "findByXxx" 规则命名即可自动生成 SQL。
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  /** 按名称精确查询 */
  List<User> findByName(String name);

  /** 按名称模糊查询 */
  List<User> findByNameContaining(String keyword);
}
