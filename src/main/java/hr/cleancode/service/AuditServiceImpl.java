package hr.cleancode.service;

import org.springframework.stereotype.Service;

/**
 * Implementation of {@link AuditService}.
 */
@Service
public class AuditServiceImpl implements AuditService {

    @Override
    public void auditOperation(String group, String info) {
        System.out.println("\nAUDIT LOG " + group + ": " + info + "\n");
    }
}
