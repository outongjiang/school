package person.otj.school.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int studentid;
    private String sname;
    private int score;
    private String gender;
    private String sno;
}
