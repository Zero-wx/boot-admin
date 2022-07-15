package com.zero.serverApi.bean.exception;


import com.zero.serverApi.bean.vo.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionResolver {
    @ExceptionHandler(value = ApplicationException.class)
    public @ResponseBody
    Object serviceCommonExceptionHandler(ApplicationException e) {
        return Result.failure(e.getMessage());
    }


    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler() {
        return new ModelAndView();
    }

}
