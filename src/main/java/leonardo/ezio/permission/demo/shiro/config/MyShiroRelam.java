package leonardo.ezio.permission.demo.shiro.config;

import leonardo.ezio.permission.demo.shiro.bean.Permission;
import leonardo.ezio.permission.demo.shiro.bean.Role;
import leonardo.ezio.permission.demo.shiro.bean.User;
import leonardo.ezio.permission.demo.shiro.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRelam extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("用户权限配置。。。。。。。。。。");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo  = (User)principals.getPrimaryPrincipal();
        for(Role role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRolename());
            for(Permission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    //验证用户登录信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("验证用户登录信息");
        String username = (String)token.getPrincipal();
        System.out.println("登录用户名： "+username);
        System.out.println(token.getCredentials());
        User user = userService.findUserByName(username);
        System.out.println("username: "+user.getUsername()+" ; password : "+user.getPassword());
        if(null == user) return null;
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
