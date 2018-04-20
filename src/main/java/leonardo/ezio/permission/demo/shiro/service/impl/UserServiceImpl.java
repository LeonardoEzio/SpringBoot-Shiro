package leonardo.ezio.permission.demo.shiro.service.impl;

import leonardo.ezio.permission.demo.shiro.bean.User;
import leonardo.ezio.permission.demo.shiro.dao.IUserDao;
import leonardo.ezio.permission.demo.shiro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }
}
