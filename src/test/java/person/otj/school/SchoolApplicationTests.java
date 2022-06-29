package person.otj.school;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import person.otj.school.mapper.StudentMapper;
import person.otj.school.mapper.UserMapper;
import person.otj.school.model.Student;
import person.otj.school.model.User;

@SpringBootTest
class SchoolApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private StudentMapper studentMapper;

    @Test
    void test1(){
        IPage<Student> page=new Page<>(1,5);
        for (Student s:studentMapper.selectPage(page,null).getRecords()){
            System.out.println(s);
        }
    }

    @Test
    void contextLoads() {
//        QueryWrapper<User>wrapper=new QueryWrapper<>();
//        wrapper.eq("username","otj").eq("password","123");
//        System.out.println(userMapper.selectCount(wrapper));
//        System.out.println(studentMapper.selectList(null));


        String zimus="qwertyuiopasdfghjklzxcvbnm";
        String shuzis="0123456789";

        int snamesIndex=(int)(Math.random()*2+8);
        int snosIndex=(int)Math.random();

        String genders=null;
        String []snames=null;
        String []snos=null;
        int scores=0;
        Student student=null;

        for (int i=0;i<=50;i++) {

            genders = (int) (Math.random()*10) > 4.5 ? "男" : "女";
            snames = zimus.split("");
            snos = shuzis.split("");
            student = new Student();
            student.setScore(String.valueOf((int)(Math.random() * 100)));
            student.setGender(genders);
            String sname = "";
            String sno = "";
            for (int j = 0; j <= 8; j++) {
                int r = (int) (Math.random()*10);
                snosIndex = r == 9 ? 8 : r;
                sno += snos[snosIndex];
            }
            for (int k = 0; k <= 2; k++) {
                snamesIndex = (int) (Math.random() * 20)+5;
                sname += snames[snamesIndex];
            }
            student.setSname(sname);
            student.setSno(sno);
            studentMapper.insert(student);
        }
    }

}
