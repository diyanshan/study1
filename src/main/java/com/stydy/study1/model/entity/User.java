package com.stydy.study1.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

/**
 * 用户实体，对应 MySQL 表 t_user。
 * 表名用 t_ 前缀是为了避开 MySQL 里 user 这个关键字带来的歧义。
 */
@Entity
@Table(name = "t_user")
public class User {

  /** 主键，交给 MySQL 自增 */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, length = 64)
  private String name = "marry";

  /** 创建时间，落库前由 @PrePersist 自动填充 */
  @Column(name = "create_time")
  private LocalDateTime createTime;

  /** 插入前自动打时间戳，避免依赖数据库默认值 */
  @PrePersist
  void onCreate() {
    this.createTime = LocalDateTime.now();
  }

  public User() {
  }

  public User(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }
}
