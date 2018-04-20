package leonardo.ezio.permission.demo.shiro.web;

import leonardo.ezio.permission.demo.shiro.bean.Permission;
import leonardo.ezio.permission.demo.shiro.bean.Role;
import leonardo.ezio.permission.demo.shiro.bean.User;
import leonardo.ezio.permission.demo.shiro.service.IUserService;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private IUserService userService;

    @RequestMapping({"/","/index"})
    public String root(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request,Map<String ,String> map){
        System.out.println("user login .....");
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        return "login";
    }

    @RequestMapping("/permission")
    @ResponseBody
    public String findPermission(){
        String username = "leonardo";
        User u = userService.findUserByName(username);
        for (Role r : u.getRoleList()){
            System.out.println(r.getRolename());
            for (Permission p : r.getPermissions()){
                System.out.println(p.getPermission());
            }
        }
        return "successful";
    }
}
