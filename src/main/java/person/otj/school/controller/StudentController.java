package person.otj.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import person.otj.school.model.Student;
import person.otj.school.service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/addStudent")
    public String addStudent(){
        return "addStudent";
    }

    @RequestMapping(value = "/studentList",method = RequestMethod.GET)
    public ModelAndView studentList(ModelAndView modelAndView){
        List<Student> studentList=studentService.findAll();
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("studentList");
        System.out.println(studentList);
        return modelAndView;
    }
}
