package com.netshell.app.portal.validations;

import com.netshell.libraries.utilities.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationExceptionMapper extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ValidationException.class})
    protected ResponseEntity<Object> handleValidationException(ValidationException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getValidationResult(), null, HttpStatus.BAD_REQUEST, request);
    }

}
