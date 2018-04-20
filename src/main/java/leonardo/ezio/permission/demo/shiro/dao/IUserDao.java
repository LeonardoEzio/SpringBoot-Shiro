package leonardo.ezio.permission.demo.shiro.dao;

import leonardo.ezio.permission.demo.shiro.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IUserDao {
    public User findUserByName(String name);
}
