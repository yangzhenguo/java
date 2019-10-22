package com.yangzg.action.emp;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.yangzg.dao.EmployeeDao;
import com.yangzg.model.Employee;
import lombok.Data;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.RequestAware;

import java.util.Map;

/**
 * Created by Sam on 2019/10/21.
 */
@Namespace("/employee")
@Results({
        @Result(name = EmployeeAction.REDIRECT_LIST, type = "redirectAction", params = {"actionName", "list"}),
})
@InterceptorRef(value = "paramsPrepareParamsStack", params = {"prepare.alwaysInvokePrepare", "false"})
@Data
public class EmployeeAction implements RequestAware, Preparable, ModelDriven<Employee> {
    public static final String REDIRECT_LIST = "redirectList";
    private EmployeeDao employeeDao = new EmployeeDao();
    private Map<String, Object> requestMap;


    private Employee employee;

    private int id;

    @Action(value = "add")
    public String add() {
        return ActionSupport.SUCCESS;
    }

    public void prepareAddSubmit() {
        this.employee = new Employee();
    }

    @Action(value = "addSubmit")
    public String addSubmit() {
        this.employeeDao.insert(this.employee);
        return REDIRECT_LIST;
    }

    public void prepareEdit() {
        this.employee = this.employeeDao.get(this.id);
    }

    @Action(value = "edit")
    public String edit() {
        return ActionSupport.SUCCESS;
    }

    public void prepareEditSubmit() {
        this.employee = new Employee();
    }

    @Action(value = "editSubmit")
    public String editSubmit() {
        this.employeeDao.update(this.employee);
        return REDIRECT_LIST;
    }

    @Action(value = "list")
    public String list() {
        requestMap.put("employees", this.employeeDao.getEmployees());
        return ActionSupport.SUCCESS;
    }

    @Action(value = "delete")
    public String delete() {
        this.employeeDao.delete(this.id);
        return REDIRECT_LIST;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.requestMap = map;
    }

    @Action("index")
    public String index() {
        return REDIRECT_LIST;
    }

    @Override
    public void prepare() throws Exception {}

    @Override
    public Employee getModel() {
        return this.employee;
    }
}
