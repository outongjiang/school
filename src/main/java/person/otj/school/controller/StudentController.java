package person.otj.school.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import person.otj.school.mapper.StudentMapper;
import person.otj.school.model.Student;
import person.otj.school.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @PostMapping("/doaddStudent")
    public String addStudent(Student student){
        studentService.save(student);
        return "addStudent";
    }

    @GetMapping("/addStudent")
    public String addStudent(){
        return "addStudent";
    }

    @RequestMapping(value = "/studentList",method = RequestMethod.GET)
    public ModelAndView studentList(ModelAndView modelAndView){
        IPage<Student> page=new Page<>(1,5);

        List<Student> studentList=studentService.findAll();

        modelAndView.addObject("current",1);
        modelAndView.addObject("studentList",studentMapper.selectPage(page,null).getRecords());
        modelAndView.setViewName("studentList");
        modelAndView.addObject("total",Math.ceil(page.getTotal()/5)-1);
        System.out.println(studentList);
        return modelAndView;
    }

    @GetMapping("/del")
    public String del(int studentid) throws IOException {
        studentService.del(studentid);
        return "redirect:/studentList";
    }

    @GetMapping("/pre")
    public ModelAndView pre(int currpage,ModelAndView modelAndView){
        IPage<Student> page=new Page<>(currpage-1<1?1:currpage-1,5);
        modelAndView.setViewName("studentList");

        modelAndView.addObject("studentList",studentMapper.selectPage(page,null).getRecords());
        modelAndView.addObject("current",currpage-1<1?1:currpage-1);
        modelAndView.addObject("total",Math.ceil(page.getTotal()/5)-1);
        return modelAndView;
    }

    @GetMapping("/next")
    public ModelAndView next(int currpage,ModelAndView modelAndView){

        IPage<Student> page=new Page<>(currpage+1,5);
        if(currpage+1>=Math.ceil(page.getTotal()/5)-1){
            currpage--;
        }
        modelAndView.setViewName("studentList");

        modelAndView.addObject("studentList",studentMapper.selectPage(page,null).getRecords());
        modelAndView.addObject("current",currpage+1);
        modelAndView.addObject("total",Math.ceil(page.getTotal()/5)-1);
        return modelAndView;
    }

    @GetMapping("/num")
    public ModelAndView page(int currpage,ModelAndView modelAndView){
        currpage++;
        IPage<Student> page=new Page<>(currpage,5);
        modelAndView.setViewName("studentList");

        modelAndView.addObject("studentList",studentMapper.selectPage(page,null).getRecords());
        modelAndView.addObject("current",currpage);
        modelAndView.addObject("total",Math.ceil(page.getTotal()/5)-1);
        return modelAndView;
    }

}