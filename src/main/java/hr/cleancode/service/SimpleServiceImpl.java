package hr.cleancode.service;

import hr.cleancode.aop.Audited;
import hr.cleancode.aop.Timed;
import org.springframework.stereotype.Service;

@Service
public class SimpleServiceImpl implements SimpleService {

    @Override
    @Timed
    public void performServiceOperation() {
        try {
            performPrivateMethod();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Timed
    @Audited(group = "pero")
    private void performPrivateMethod() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
