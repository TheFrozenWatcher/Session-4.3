package module4.ex.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import module4.ex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        if (userRepository.findUserByPhoneNumber(phone) != null) {
            return false;
        }
        if (phone == null || phone.isEmpty()) {
            return true;
        }
        return phone.matches("\\d{10,15}");
    }
}
