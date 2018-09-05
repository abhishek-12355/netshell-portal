package com.netshell.app.portal.validations;

import com.netshell.app.portal.models.User;
import com.netshell.libraries.utilities.common.CommonMethods;
import com.netshell.libraries.utilities.validation.ValidationException;
import com.netshell.libraries.utilities.validation.ValidationResult;
import com.netshell.libraries.utilities.validation.ValidationStrategy;

public class UserValidation implements ValidationStrategy<User> {
    @Override
    public User validate(User user) throws ValidationException {
        ValidationException exception = new ValidationException("Validation Failed: User Invalid");
        if (CommonMethods.isEmpty(user.getUsername())) {
            exception.add(new ValidationResult.ValidationResultItem("username"));
        }

        if (CommonMethods.isEmpty(user.getPassword())) {
            exception.add(new ValidationResult.ValidationResultItem("password"));
        }

        if (!exception.getValidationResult().getValidationResultItemList().isEmpty()) {
            throw exception;
        }

        return user;

    }

    @Override
    public String getName() {
        return User.class.getName();
    }
}
