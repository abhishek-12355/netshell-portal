
package com.netshell.app.portal.validations;

import com.netshell.app.portal.models.PortalApplication;
import com.netshell.libraries.utilities.common.CommonMethods;
import com.netshell.libraries.utilities.validation.ValidationException;
import com.netshell.libraries.utilities.validation.ValidationResult;
import com.netshell.libraries.utilities.validation.ValidationStrategy;

public class PortalApplicationValidation implements ValidationStrategy<PortalApplication> {
    @Override
    public PortalApplication validate(PortalApplication application) throws ValidationException {
        ValidationException exception = new ValidationException("Validation Failed: Application Invalid");
        if (CommonMethods.isEmpty(application.getName())) {
            exception.add(new ValidationResult.ValidationResultItem("name"));
        }

        if (application.getUri() == null || CommonMethods.isEmpty(application.getUri())) {
            exception.add(new ValidationResult.ValidationResultItem("uri"));
        }

        if (CommonMethods.isEmpty(application.getDomain())) {
            exception.add(new ValidationResult.ValidationResultItem("domain"));
        }

        if (!exception.getValidationResult().getValidationResultItemList().isEmpty()) {
            throw exception;
        }

        return application;

    }

    @Override
    public String getName() {
        return PortalApplication.class.getName();
    }
}
