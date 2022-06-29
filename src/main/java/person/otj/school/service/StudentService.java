package person.otj.school.service;
import person.otj.school.model.Student;
import java.util.List;
public interface StudentService {
    List<Student> findAll();
    int save(Student student);

    int del(int studentid);
}
