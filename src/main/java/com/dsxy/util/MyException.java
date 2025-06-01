package com.dsxy.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.dsxy.util.Result.ERROR;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class MyException {
    @ExceptionHandler(value={Exception.class})
    @ResponseBody
    public <T> Result<T> exceptionHandler(Exception e) {
        return Result.error(ERROR,"服务端异常");
    }
}
