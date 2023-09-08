package tm;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;

import java.sql.Date;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentTM {
    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private Date dob;
    private String gender;
}
