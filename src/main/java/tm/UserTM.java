package tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserTM {
    private String userId;
    private String userName;
    private String email;
    private String password;
}
