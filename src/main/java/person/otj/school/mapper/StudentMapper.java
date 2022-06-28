package person.otj.school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import person.otj.school.model.Student;

@Repository
public interface StudentMapper extends BaseMapper<Student> {

}
