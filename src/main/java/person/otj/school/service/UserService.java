package person.otj.school.service;


public interface UserService {
    int findUserByUnamePwd(String username, String password);

    int save(String username, String password);
}
