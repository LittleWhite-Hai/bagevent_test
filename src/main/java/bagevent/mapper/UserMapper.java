package bagevent.mapper;

import bagevent.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> list();
    User get(String name);
    int insert(User u);
}
