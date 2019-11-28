package com.yangzg.crud.controller;

import com.yangzg.crud.model.Employee;
import com.yangzg.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Sam on 2019/11/24.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("password");
        dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));

        dataBinder.addValidators(new Validator() {
            @Override
            public boolean supports(Class<?> clazz) {
                return false;
            }

            @Override
            public void validate(Object target, Errors errors) {

            }
        });
    }

    @ModelAttribute
    public void getByUid(@RequestParam(required = false) String uid, Map<String, Object> map) {
        if (!StringUtils.isEmpty(uid)) {
            this.employeeService.getByUid(uid).ifPresent(employee -> map.put("employee", employee));
        }
    }

    @GetMapping
    public String index() {
        return "redirect:/employee/list";
    }

    @GetMapping("/input")
    public String input(Map<String, Object> map) {
        map.put("employee", new Employee());
        return "employee/input";
    }

    @PostMapping
    public String createSubmit(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "employee/input";
        }
        this.employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/info/{uid}")
    public String info(@PathVariable String uid, Map<String, Object> map) {
        map.put("employee", this.employeeService.getByUid(uid).orElseThrow(() -> new RuntimeException("not exists")));
        return "employee/info";
    }

    @GetMapping("/edit/{uid}")
    public String edit(@PathVariable String uid, Map<String, Object> map) {
        map.put("employee", this.employeeService.getByUid(uid).orElseThrow(() -> new RuntimeException("not exists")));
        return "employee/input";
    }

    @PutMapping
    public String editSubmit(@Valid Employee employee, BindingResult bindingResult, Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            return "employee/input";
        }
        this.employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("employees", this.employeeService.listAll());
        return "employee/list";
    }

    @DeleteMapping("/{uid}")
    public String delete(@PathVariable String uid) throws IOException {
        this.employeeService.removeByUid(uid);
        return "redirect:/employee/list";
    }
}
