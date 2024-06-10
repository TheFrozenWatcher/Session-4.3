package module4.ex.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import module4.ex.model.dto.request.UserRequest;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserRequest> {

    @Override
    public boolean isValid(UserRequest request, ConstraintValidatorContext context) {
        if (request.getPassword() == null || request.getRepeatPassword() == null) {
            return false;
        }
        return request.getPassword().equals(request.getRepeatPassword());
    }
}
