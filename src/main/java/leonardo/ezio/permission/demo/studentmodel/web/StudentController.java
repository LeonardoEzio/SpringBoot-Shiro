package leonardo.ezio.permission.demo.studentmodel.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stu")
public class StudentController {

    @RequestMapping("/addStu")
    @RequiresRoles("admin")
    @RequiresPermissions("student:add")
    public String addStu(){
        System.out.println("add  Stu");
        return "addStu";
    }

}
