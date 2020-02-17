package bagevent.mapper;

import bagevent.pojo.LoginLog;

import java.util.List;

public interface LoginLogMapper {
    List<LoginLog> list(int uid);
    int add(LoginLog log);
}
