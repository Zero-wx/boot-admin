package com.lumlord.springserverapi.exception;

import com.lumlord.springserverapi.utils.vo.Results;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionResolver {
    @ExceptionHandler(value = ApplicationException.class)
    public @ResponseBody
    Object serviceCommonExceptionHandler(ApplicationException e) {
        return Results.failure(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler() {
        return new ModelAndView();
    }
}
