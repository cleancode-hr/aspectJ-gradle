package hr.cleancode.aop;

import hr.cleancode.service.AuditService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Aspect
@Configurable
public class AuditedAspect {

    @Autowired
    private AuditService auditService;

    @Pointcut("execution(@hr.cleancode.aop.Audited * * (..)) && @annotation(audited)")
    public void auditedPointcut(Audited audited) {
    }

    @AfterThrowing(pointcut = "auditedPointcut(audited)", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Audited audited, Throwable e) {
    }

    @Around("auditedPointcut(audited)")
    public Object logAround(ProceedingJoinPoint joinPoint, Audited audited) throws Throwable {
        auditService.auditOperation(audited.group(), joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }
}