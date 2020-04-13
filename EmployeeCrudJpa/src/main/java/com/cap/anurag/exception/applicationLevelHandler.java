package com.cap.anurag.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cap.anurag.entities.ErrorInfo;

@ControllerAdvice
public class applicationLevelHandler {
@ResponseBody
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@ExceptionHandler({ Exception.class })
protected ErrorInfo handleConflict(Exception ex,HttpServletRequest req) {
String bodyOfResponse=ex.getMessage();
String url=req.getRequestURL().toString();
return new ErrorInfo(url,bodyOfResponse);
}
}
