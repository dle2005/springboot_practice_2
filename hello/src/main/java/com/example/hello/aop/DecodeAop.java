package com.example.hello.aop;

import com.example.hello.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.hello.controller..*.*(..))")
    private void cut() {
    }

    @Pointcut("@annotation(com.example.hello.annotation.Decode)")
    private void enableDecode() {
    }

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof User) {
                User user = User.class.cast(arg);
                String base64Address = user.getAddress();
                String address = new String(Base64.getDecoder().decode(base64Address), "UTF-8");
                user.setAddress(address);
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void AfterReturn(JoinPoint joinPoint, Object returnObj) {
        if (returnObj instanceof User) {
            User user = User.class.cast(returnObj);
            String address = user.getAddress();
            String base64Address = Base64.getEncoder().encodeToString(address.getBytes());
            user.setAddress(base64Address);
        }
    }
}
