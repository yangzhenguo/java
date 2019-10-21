package com.yangzg.action.emp;

import com.opensymphony.xwork2.ActionSupport;
import com.yangzg.dao.EmployeeDao;
import lombok.Data;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;

import java.util.Map;

/**
 * Created by Sam on 2019/10/21.
 */
@Namespace("/employee")
@Results({
        @Result(name = ActionSupport.INPUT, location = "/WEB-INF/pages/employee/input.jsp"),
        @Result(name = ActionSupport.SUCCESS, location = "/WEB-INF/pages/employee/success.jsp"),
        @Result(name = "list", location = "/WEB-INF/pages/employee/list.jsp"),
        @Result(name = "delete", type = "redirect", location = "list"),
})
@Data
public class EmployeeAction implements RequestAware {
    private EmployeeDao employeeDao = new EmployeeDao();
    private Map<String, Object> requestMap;

    private int id;

    /*
    private String name;
    private String password;
    private String gender;
    private String department;
    private List<String> roles;
    private String desc;
    */

    @Action(value = "input")
    public String input() {
        this.requestMap.put("departments", employeeDao.getDepartments());
        this.requestMap.put("roles", employeeDao.getRoles());
        return ActionSupport.INPUT;
    }

    @Action(value = "submit")
    public String submit() {
        System.out.println(this);
        return ActionSupport.SUCCESS;
    }

    @Action(value = "list")
    public String list() {
        requestMap.put("employees", this.employeeDao.getEmployees());
        return "list";
    }

    @Action(value = "delete")
    public String delete() {
        this.employeeDao.delete(this.id);
        return "delete";
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.requestMap = map;
    }
}
