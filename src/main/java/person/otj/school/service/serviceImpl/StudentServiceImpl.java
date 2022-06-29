package person.otj.school.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.otj.school.mapper.StudentMapper;
import person.otj.school.model.Student;
import person.otj.school.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.selectList(null);
    }

    @Override
    public int save(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int del(int studentid) {
        QueryWrapper<Student>wrapper=new QueryWrapper<>();
        wrapper.eq("studentid",studentid);
        return studentMapper.delete(wrapper);
    }
}
