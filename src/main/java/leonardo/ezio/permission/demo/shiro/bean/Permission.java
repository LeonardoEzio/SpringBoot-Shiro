package leonardo.ezio.permission.demo.shiro.bean;

import java.util.List;

public class Permission {
    private int id;
    private String modelname;
    private String permission;

    private List<Role> roles;//角色权限关系   多对多

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
