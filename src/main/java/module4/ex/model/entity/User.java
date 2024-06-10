package module4.ex.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Field cannot be empty")
    private String username;
    @NotBlank(message = "Field cannot be empty")

    private String password;
    @NotBlank(message = "Field cannot be empty")

    private String fullName;
    @NotBlank(message = "Field cannot be empty")
    private String address;
    @NotBlank(message = "Field cannot be empty")
    private String email;
    @NotBlank(message = "Field cannot be empty")
    private String phone;
    private boolean status;



}
