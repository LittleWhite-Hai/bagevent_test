package bagevent.service.impl;

import bagevent.mapper.LoginLogMapper;
import bagevent.mapper.UserMapper;
import bagevent.pojo.LoginLog;
import bagevent.pojo.User;
import bagevent.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LoginLogServiceImpl implements LoginLogService{
    @Autowired
    LoginLogMapper loginLogMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<LoginLog> list(int uid){
        return loginLogMapper.list(uid);
    }
    @Override
    public int add(User u,HttpServletRequest request){
        LoginLog log=injectLog(u,request);
        loginLogMapper.add(log);
        return 0;
    }
    public LoginLog injectLog(User u,HttpServletRequest request){

        LoginLog loginLog=new LoginLog();
        loginLog.setUser_id(u.getUser_id());
        Date d = new Date(); // 注意是util包下的Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        loginLog.setLogin_time(sdf.format(d));

        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        loginLog.setLogin_ip(remoteAddr);


        return loginLog;
    }
}
