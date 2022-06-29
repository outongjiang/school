package person.otj.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PageController {
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }



}
