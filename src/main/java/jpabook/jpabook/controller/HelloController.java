package jpabook.jpabook.controller;

import jdk.jfr.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {


    @Description("이건가?")
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello";
    }
}
