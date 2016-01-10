package hr.cleancode;

import hr.cleancode.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Application entry point.
 */
@Component
public class MyApplication {

    @Autowired
    private SimpleService simpleService;

    public void start() {
        simpleService.performServiceOperation();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("hr.cleancode");
        MyApplication main = ctx.getBean(MyApplication.class);
        main.start();
    }
}
