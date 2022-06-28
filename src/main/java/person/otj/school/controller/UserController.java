package person.otj.school.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import person.otj.school.model.User;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/login"},method = {RequestMethod.POST,RequestMethod.GET})
    public String login(){
        return "login";
    }

    @PostMapping("/dologin")
    public String dologin(User user){
        userService.findUserByUnamePwd(user.get)
    }


}
