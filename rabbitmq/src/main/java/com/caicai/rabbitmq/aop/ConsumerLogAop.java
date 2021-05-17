package com.caicai.rabbitmq.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

import static com.caicai.rabbitmq.constant.BusinessConstant.TID;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ConsumerLogAop
 * @Package: com.caicai.rabbitmq.aop
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/14 18:21
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */

@Slf4j
@Aspect
@Component
public class ConsumerLogAop {

    @Pointcut(value = "execution(* com.caicai.rabbitmq.consumer.*.*(..))")
    private void pointcut() {    }


    @Around("pointcut()")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String headerTid = getHeaderTid(joinPoint);
        System.out.println("headerTid = " + headerTid);
        Object resultObj = joinPoint.proceed();
        return resultObj;
    }


    private static String getHeaderTid(ProceedingJoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            Annotation[][] annotations = method.getParameterAnnotations();
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                if (arg instanceof Message) {
                    Message message = (Message) arg;
                    Object o = message.getHeaders().get(TID);
                    return String.valueOf(o);
                }


                Annotation[] annotation = annotations[i];
                for (Annotation anno : annotation) {
                    if (anno.annotationType() == Header.class) {
                        Header header = (Header) anno;
                        if (ObjectUtils.nullSafeEquals(header.name(), TID)) {
                            return String.valueOf(arg);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}
