package entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString



@Table(
        uniqueConstraints = {@UniqueConstraint(name = "unique_email", columnNames = "email"),
                @UniqueConstraint(name = "unique_userName", columnNames = "userName")}
)

@NamedQuery(
        name = "User.findLatestUserId",
        query = "SELECT u.userId FROM user u ORDER BY u.userId DESC"
)

@Entity
public class user {
    @Id
    private String userId;
    private String userName;
    private String email;
    private String password;
}
