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
import person.otj.school.model.PageVo;
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

    @GetMapping("/del")
    public String del(int studentid) throws IOException {
        studentService.del(studentid);
        return "redirect:/studentList";
    }

    @RequestMapping(value = "/studentList",method = RequestMethod.GET)
    public ModelAndView studentList(ModelAndView modelAndView){
        IPage<Student> page=new Page<>(1,5);
        page=studentMapper.selectPage(page,null);
        PageVo pageVo=new PageVo();
        pageVo.setSize(5);
        pageVo.setTotal((int)page.getTotal());
        pageVo.setCurrpage(1);
        pageVo.setStudents(page.getRecords());
        modelAndView.addObject("pageVo",pageVo);
        modelAndView.setViewName("studentList");
        return modelAndView;
    }



    @GetMapping("/pre")
    public ModelAndView pre(PageVo pageVo,ModelAndView modelAndView){

        IPage<Student> page=new Page<>(pageVo.getCurrpage()-1,5);
        page=studentMapper.selectPage(page,null);
        pageVo.setCurrpage(pageVo.getCurrpage()-1);
        pageVo.setStudents(page.getRecords());
        modelAndView.addObject("pageVo",pageVo);
        modelAndView.setViewName("studentList");
        return modelAndView;
    }

    @GetMapping("/next")
    public ModelAndView next(PageVo pageVo,ModelAndView modelAndView){

        IPage<Student> page=new Page<>(pageVo.getCurrpage()+1,5);
        page=studentMapper.selectPage(page,null);
        pageVo.setCurrpage(pageVo.getCurrpage()+1);
        pageVo.setStudents(page.getRecords());
        modelAndView.addObject("pageVo",pageVo);
        modelAndView.setViewName("studentList");
        return modelAndView;
    }

    @GetMapping("/num")
    public ModelAndView page(PageVo pageVo,ModelAndView modelAndView){
        System.out.println("总页数->"+pageVo.getTotal());
        IPage<Student> page=new Page<>(pageVo.getCurrpage(),5);
        page=studentMapper.selectPage(page,null);
        pageVo.setCurrpage(pageVo.getCurrpage());
        pageVo.setStudents(page.getRecords());
        modelAndView.addObject("pageVo",pageVo);
        modelAndView.setViewName("studentList");
        return modelAndView;
    }

}