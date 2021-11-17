package ru.spin.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("hello")
    public String sayHello() {
        return "hello";
    }
}
