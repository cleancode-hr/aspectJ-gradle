package hr.cleancode.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@ComponentScan(basePackages = "hr.cleancode")
@EnableAspectJAutoProxy
@EnableSpringConfigured
public class TestConfiguration {
}
