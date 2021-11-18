package ru.spin.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

   /* @GetMapping("/hello")
    public String sayHello(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println(name + " " + surname);

        return "first/hello";
    }*/

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name, //@RequestParam("name") String name, - если параметр обязателен
                           @RequestParam(value = "surname", required = false) String surname, //@RequestParam("surname") String surname)
                           Model model) {
        //System.out.println(name + " " + surname);
        model.addAttribute("greetings", "Hello, " + name + " " + surname);

        return  "first/hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String countDigits(@RequestParam(name = "a", defaultValue = "1") int a,
                              @RequestParam(name = "b", defaultValue = "1") int b,
                              @RequestParam(name = "operation", defaultValue = "multiplication") String operation,
                              Model model) {
        double result = 0;
        switch(operation) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / (double) b;
                break;
        }

        model.addAttribute("result", result);

        return "first/calculator";
    }
}
