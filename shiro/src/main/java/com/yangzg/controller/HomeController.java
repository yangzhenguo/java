package com.yangzg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sam on 2019/6/24.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping({"", "/"})
    public String index() {
        return "home";
    }

    @RequestMapping("/array")
    public String array(Model model) {
        List<Integer> datas = new Random().ints(10, 100, 1000000).boxed().collect(Collectors.toList());
        model.addAttribute("datas", datas);
        return "array";
    }

    @RequestMapping("/files")
    public String files(Model model) {
        try (Stream<Path> paths = Files.walk(Paths.get("."), 1)) {
            model.addAttribute("datas", paths.map(path -> path.toAbsolutePath().toString()).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("datas", new ArrayList<>());
        }
        return "files";
    }
}
