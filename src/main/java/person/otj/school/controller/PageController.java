package person.otj.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @PostMapping("/register")
    public String register(){
        System.out.println("进入register....");
        return "register";
    }
}
