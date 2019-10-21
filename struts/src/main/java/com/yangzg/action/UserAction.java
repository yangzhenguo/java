package com.yangzg.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.struts2.convention.annotation.*;

/**
 * Created by Sam on 2019/10/21.
 */
@Namespace("/user")
@ExceptionMapping(result = "exception", exception = "java.lang.Exception")
@Results({
        @Result(name = ActionSupport.ERROR, location = "/WEB-INF/pages/error.jsp"),
        @Result(name = ActionSupport.INPUT, location = "/WEB-INF/pages/user/input.jsp"),
        @Result(name = ActionSupport.SUCCESS, location = "/WEB-INF/pages/user/success.jsp")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAction {
    private String userId;
    private String username;
    private String password;
    private String desc;
    private Boolean married;

    @Action(value = "input")
    public String input() {
        return ActionSupport.INPUT;
    }

    @Action("submit")
    public String submit() {
        return ActionSupport.INPUT;
    }
}
