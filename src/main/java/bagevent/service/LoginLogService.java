package bagevent.service;

import bagevent.pojo.LoginLog;
import bagevent.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginLogService {
    List<LoginLog> list(int uid);
    int add(User u, HttpServletRequest request);
}
