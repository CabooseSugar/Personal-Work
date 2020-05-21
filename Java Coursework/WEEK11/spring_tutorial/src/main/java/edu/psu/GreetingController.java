package edu.psu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class GreetingController {

    @RequestMapping("/")
    public String index() {
        return "Spring is an awesome framework!";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye() {
        return "goodbye";
    }

}