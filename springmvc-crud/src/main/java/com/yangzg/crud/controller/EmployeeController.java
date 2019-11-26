package com.yangzg.crud.controller;

import com.yangzg.crud.model.Employee;
import com.yangzg.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    public String createSubmit(Employee employee) {
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
    public String editSubmit(Employee employee) {
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
