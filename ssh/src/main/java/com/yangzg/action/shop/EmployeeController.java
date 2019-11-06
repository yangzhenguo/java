package com.yangzg.action.shop;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.yangzg.model.Employee;
import com.yangzg.service.inf.DepartmentService;
import com.yangzg.service.inf.EmployeeService;
import lombok.Setter;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

/**
 * Created by Sam on 2019/11/5.
 */
@Controller
@Scope("prototype")
@Namespace("/shop/employee")
@Result(name = EmployeeController.REDIRECT, type = "redirect", location = "/shop/employee/list")
public class EmployeeController extends ActionSupport implements RequestAware, Preparable, ModelDriven<Employee> {
    private static final long serialVersionUID = 1L;
    protected static final String REDIRECT = "redirect";

    @Autowired private EmployeeService employeeService;

    @Autowired private DepartmentService departmentService;

    private Employee employee;

    @Setter
    private Integer id;

    private Map<String, Object> request;

    @Action("list")
    public String list() {
        request.put("employees", this.employeeService.listAll());
        return SUCCESS;
    }

    @Action(value = "")
    public String index() {
        return "redirect";
    }

    @Action("create")
    public String create() {
        this.request.put("departments", this.departmentService.listAll());
        return SUCCESS;
    }

    public void prepareCreateSubmit() {
        this.employee = new Employee();
    }

    @Action(value = "createSubmit", interceptorRefs = @InterceptorRef(value = "paramsPrepareParamsStack", params = {"alwaysInvokePrepare", "false"}))
    public String createSubmit() {
        this.employee.setCreateTime(Date.from(Instant.now()));
        this.employeeService.create(this.employee);
        return REDIRECT;
    }

    @Action("delete")
    public String delete() {
        this.employeeService.delete(id);
        return REDIRECT;
    }

    public void prepareEdit() {
        this.employeeService.get(id).ifPresent(model -> this.employee = model);
    }

    @Action(value = "edit", interceptorRefs = @InterceptorRef(value = "paramsPrepareParamsStack", params = {"alwaysInvokePrepare", "false"}))
    public String edit() {
        this.request.put("departments", this.departmentService.listAll());
        return SUCCESS;
    }

    public void prepareEditSubmit() {
        this.employee = new Employee();
    }

    @Action(value = "editSubmit", interceptorRefs = @InterceptorRef(value = "paramsPrepareParamsStack", params = {"alwaysInvokePrepare", "false"}))
    public String editSubmit() {
        this.employeeService.edit(this.employee);
        return REDIRECT;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public Employee getModel() {
        return this.employee;
    }

    @Override
    public void prepare() throws Exception {

    }
}
