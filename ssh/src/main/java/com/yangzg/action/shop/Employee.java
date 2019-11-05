package com.yangzg.action.shop;

import com.opensymphony.xwork2.ActionSupport;
import com.yangzg.service.inf.EmployeeService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by Sam on 2019/11/5.
 */
@Controller
@Scope("prototype")
@Namespace("/shop/employee")
public class Employee extends ActionSupport implements RequestAware {
    private static final long serialVersionUID = 1L;
    @Autowired
    private EmployeeService employeeService;

    private Map<String, Object> request;

    @Actions({ @Action("list"), @Action(value = "index", results = @Result(location = "list.jsp")) })
    public String list() {
        request.put("employees", this.employeeService.listAll());
        return SUCCESS;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }
}
