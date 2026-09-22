package com.stydy.study1.controller;

import com.stydy.study1.model.entity.User;
import com.stydy.study1.service.UserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  /** 查询全部：GET /user/list */
  @GetMapping("/list")
  public List<User> list() {
    return userService.listAll();
  }

  /** 按 id 查询：GET /user/searchUser?id=1 */
  @GetMapping("/searchUser")
  public ResponseEntity<User> searchUser(@RequestParam Long id) {
    return userService.searchUserById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  /** 按名称模糊查询：GET /user/search?keyword=ma */
  @GetMapping("/search")
  public List<User> search(@RequestParam String keyword) {
    return userService.searchUserByKeyword(keyword);
  }

  /** 新增：POST /user/create?name=tom */
  @PostMapping("/create")
  public User create(@RequestParam String name) {
    return userService.createUser(name);
  }

  /** 删除：DELETE /user/1 */
  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    return userService.deleteUser(id)
        ? ResponseEntity.ok("deleted")
        : ResponseEntity.notFound().build();
  }
}
