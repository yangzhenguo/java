package com.yangzg.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by Sam on 2019/10/21.
 */
@Namespace("/")
@Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = {"namespace", "/employee", "actionName", "list"})
public class IndexAction {
    @Action(value = "index")
    public String index() {
        return ActionSupport.SUCCESS;
    }
}
