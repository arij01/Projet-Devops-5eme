package tn.esprit.tpfoyer.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ConfigAOP {

    @Before("execution(* tn.esprit.tpfoyer.service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Entering method: " + methodName);
    }

    @After("execution(* tn.esprit.tpfoyer.service.*.add*(..))")
    public void logMethodOut(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Method executed successfully: " + methodName);
    }

    @Around("execution(* tn.esprit.tpfoyer.service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        long start = System.currentTimeMillis();

        Object result = pjp.proceed();

        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Execution time of method " + methodName + ": " + elapsedTime + " milliseconds.");

        return result;
    }
}
