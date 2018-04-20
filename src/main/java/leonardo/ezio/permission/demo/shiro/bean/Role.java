package leonardo.ezio.permission.demo.shiro.bean;

import java.util.List;

//角色类
public class Role {

    private int id;
    private String rolename;//角色名称
    private String roledesc;//角色描述

    private List<Permission> permissions;//角色权限关系  多对多  一个角色对应多个权限

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
