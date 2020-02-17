package bagevent.service.impl;

import bagevent.mapper.UserMapper;
import bagevent.pojo.User;
import bagevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list(){
       return userMapper.list();
    }
    @Override
    public User get(String name){
        return userMapper.get(name);
    }
    @Override
    public int insert(User u){
        userMapper.insert(u);
        return 0;
    }
}
