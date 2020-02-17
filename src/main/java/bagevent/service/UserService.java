package bagevent.service;

import bagevent.pojo.User;

import java.util.List;

public interface UserService {
List<User> list();
User get(String name);
int insert(User u);
}
