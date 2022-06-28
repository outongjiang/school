package person.otj.school;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import person.otj.school.mapper.StudentMapper;
import person.otj.school.mapper.UserMapper;
import person.otj.school.model.User;

@SpringBootTest
class SchoolApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private StudentMapper studentMapper;

    @Test
    void contextLoads() {
//        QueryWrapper<User>wrapper=new QueryWrapper<>();
//        wrapper.eq("username","otj").eq("password","123");
//        System.out.println(userMapper.selectCount(wrapper));
        System.out.println(studentMapper.selectList(null));
    }

}
