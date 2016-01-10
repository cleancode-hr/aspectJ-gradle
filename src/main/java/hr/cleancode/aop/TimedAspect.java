package hr.cleancode.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Aspect for timing methods.
 */
@Aspect
@Configurable
public class TimedAspect {

    @Pointcut("execution(@hr.cleancode.aop.Timed * * (..)) && @annotation(timed)")
    public void timedPointcut(Timed timed) {
    }

    @AfterThrowing(pointcut = "timedPointcut(timed)", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Timed timed, Throwable e) {
    }

    @Around("timedPointcut(timed)")
    public Object logAround(ProceedingJoinPoint joinPoint, Timed timed) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("\n### BEGIN execution of " + joinPoint.getSignature().getName() + " ### \n");
        try {
            return joinPoint.proceed();
        } finally {
            System.out.println("\n### END execution of " + joinPoint.getSignature().getName() + " took " + String.valueOf(System.currentTimeMillis() - startTime) + " ms ### \n");
        }
    }
}
