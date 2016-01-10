package hr.cleancode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@ComponentScan(basePackages = "hr.cleancode")
@EnableAspectJAutoProxy
@EnableSpringConfigured
@Configuration
public class MyConfiguration {
}
