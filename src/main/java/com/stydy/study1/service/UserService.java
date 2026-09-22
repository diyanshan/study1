package com.stydy.study1.service;

import com.stydy.study1.model.entity.User;
import com.stydy.study1.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  private final UserRepository userRepository;

  /** 构造器注入：Bean 由 Spring 装配，单测里也能直接 new 出来 */
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> listAll() {
    return userRepository.findAll();
  }

  public Optional<User> searchUserById(Long id) {
    return userRepository.findById(id);
  }

  public List<User> searchUserByName(String name) {
    return userRepository.findByName(name);
  }

  public List<User> searchUserByKeyword(String keyword) {
    return userRepository.findByNameContaining(keyword);
  }

  @Transactional
  public User createUser(String name) {
    return userRepository.save(new User(name));
  }

  @Transactional
  public boolean deleteUser(Long id) {
    if (!userRepository.existsById(id)) {
      return false;
    }
    userRepository.deleteById(id);
    return true;
  }
}
