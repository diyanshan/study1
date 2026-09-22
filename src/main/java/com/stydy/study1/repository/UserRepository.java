package com.stydy.study1.repository;

import java.util.Collection;
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

  /**
   * 按 id 集合查询，始终返回 List（数组语义）。
   * 用 In 关键字，生成的是 where id in (?, ?, ...)；
   * 传入单个 id 也能用，查不到就是空数组，不会抛异常。
   */
  List<User> findByIdIn(Collection<Long> ids);
}
