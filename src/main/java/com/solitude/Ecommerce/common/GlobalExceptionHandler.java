package com.solitude.Ecommerce.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException exception) {
        log.info(exception.getMessage());

        if (exception.getMessage().contains("Duplicate entry")){
            String[] split = exception.getMessage().split(" ");
            String msg = split[2] + " Presence";
            return R.error(msg);
        }
        return R.error("Unknown error");
    }

    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException exception) {
        log.info(exception.getMessage());
        return R.error(exception.getMessage());
    }
}
