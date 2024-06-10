package module4.ex.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import module4.ex.validation.UniqueUsername;
import module4.ex.validation.UniqueEmail;
import module4.ex.validation.ValidPhoneNumber;
import module4.ex.validation.PasswordMatches;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class UserRequest {
    @NotBlank(message = "Field cannot be empty")
    @UniqueUsername
    private String username;

    @NotBlank(message = "Field cannot be empty")
    private String password;

    private String repeatPassword;

    @NotBlank(message = "Field cannot be empty")
    private String fullName;

    @NotBlank(message = "Field cannot be empty")
    private String address;

    @NotBlank(message = "Field cannot be empty")
    @Email(message = "Invalid email format")
    @UniqueEmail
    private String email;

    @NotBlank(message = "Field cannot be empty")
    @ValidPhoneNumber
    private String phone;

    private boolean status;
}
