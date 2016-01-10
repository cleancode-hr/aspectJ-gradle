package hr.cleancode.service;

public interface AuditService {

    void auditOperation(String group, String info);
}
