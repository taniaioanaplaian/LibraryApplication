package validators.impl;

import model.entity.User;
import model.enumeration.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    void isValid() {
        User user = new User();
        UserValidator validator = new UserValidator();
        user.setUserName("Anamaria");
        user.setRole(Role.EMPLOYEE);
        user.setPassword("ana");
        assert !validator.isValid(user);
        user.setPassword("?anaMaria1998");
        assert validator.isValid(user);

    }
}