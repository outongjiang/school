package person.otj.school.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import person.otj.school.model.User;
import person.otj.school.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/login"},method = {RequestMethod.POST,RequestMethod.GET})
    public String login(){
        return "login";
    }

    @PostMapping("/dologin")
    public ModelAndView dologin(User user, ModelAndView modelAndView){
        if(userService.findUserByUnamePwd(user.getUsername(),user.getPassword())==1){
            modelAndView.addObject(user);
            modelAndView.setViewName("studentList");

        }else
        {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }


}
