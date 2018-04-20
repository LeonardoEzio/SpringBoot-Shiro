package leonardo.ezio.permission.demo.shiro.service;

import leonardo.ezio.permission.demo.shiro.bean.User;
import org.springframework.stereotype.Service;


public interface IUserService {
    public User findUserByName(String name);
}
