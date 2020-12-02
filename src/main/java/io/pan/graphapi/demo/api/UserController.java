package io.pan.graphapi.demo.api;

import io.pan.graphapi.demo.user.User;
import io.pan.graphapi.demo.user.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

  private final Users users;

  public UserController(Users users) {
    this.users = users;
  }

  @GetMapping
  public List<User> getUser() {
    return users.all();
  }
}
