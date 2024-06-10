package module4.ex.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import module4.ex.model.dto.request.UserRequest;
import module4.ex.model.entity.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserConverter {
    public User toUser(UserRequest request){
        return User.builder()
                        .username(request.getUsername())
                .password(BCrypt.hashpw(request.getPassword(),BCrypt.gensalt(12)))
                .fullName(request.getFullName())
                .address(request.getAddress())
                .email(request.getEmail())
                .phone(request.getPhone())
                .status(request.isStatus())
                .build();
    }
}
