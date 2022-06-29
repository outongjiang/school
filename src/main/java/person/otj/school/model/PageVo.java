package person.otj.school.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageVo {

    private int currpage;
    private int size;
    private int total;
    private List<Student>students;

}
