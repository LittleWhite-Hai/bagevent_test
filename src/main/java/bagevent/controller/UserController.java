package bagevent.controller;

import bagevent.pojo.LoginLog;
import bagevent.pojo.User;
import bagevent.service.LoginLogService;
import bagevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    LoginLogService loginLogService;
    @RequestMapping("register")
    public String register(Model model){
        return "sign_up";
    }
    @RequestMapping("login")
    public String login(Model model){

        return "login";
    }
    @RequestMapping("loginSubmit")
    public String loginSubmit(Model model,User user,HttpServletRequest request){

        String name =  user.getUser_name();
        name = HtmlUtils.htmlEscape(name);
        user.setUser_name(name);
        User iu=userService.get(name);
        try {
            int i;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(user.getPassword().getBytes());
            user.setPassword( new BigInteger(1, md.digest()).toString(16));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(null!=iu&&iu.getPassword().equals(user.getPassword())) {
         /*   session.setAttribute("uid",iu.getUser_id());*/
            loginLogService.add(iu,request);
            List<LoginLog> ls=loginLogService.list(iu.getUser_id());
            model.addAttribute("ls",ls);
            return "Log_list";
        }
        model.addAttribute("msg","登录信息错误");
        return "login";
    }
    @RequestMapping("register_submit")
    public String registerSubmit(Model model,User user){
        String name =  user.getUser_name();
        name = HtmlUtils.htmlEscape(name);
        user.setUser_name(name);
        boolean exist=(null!=userService.get(name));
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
            model.addAttribute("user", null);
            return "sign_up";
        }
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(user.getPassword().getBytes());
            user.setPassword( new BigInteger(1, md.digest()).toString(16));
        } catch (Exception e) {
            e.printStackTrace();
        }
        userService.insert(user);
        return "Success";
    }
    @RequestMapping("list_User")
    public String list(Model model){
        List<User> us= userService.list();
        for(User u:us){
            System.out.println(u.getUser_id()+"        "+u.getUser_name());
        }
        model.addAttribute("us", us);
        return "user_list";
    }
}
