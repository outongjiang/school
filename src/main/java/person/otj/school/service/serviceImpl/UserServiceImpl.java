package person.otj.school.service.serviceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.otj.school.mapper.UserMapper;
import person.otj.school.model.User;
import person.otj.school.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int findUserByUnamePwd(String username, String password) {
        QueryWrapper<User>wrapper=new QueryWrapper<>();
        wrapper.eq("username",username).eq("password",password);
        return userMapper.selectCount(wrapper)>0?1:0;
    }
}
