package com.yangzg.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;


/**
 * Created by Sam on 2019/11/5.
 */
@Namespace("/")
public class Index extends ActionSupport {
    private static final long serialVersionUID = 4234521775007292096L;

    @Override
    @Action(results = @Result(type = "redirectAction", params = {"namespace", "/shop/employee", "actionName", "list"}))
    public String execute() throws Exception {
        return super.execute();
    }
}
