package hr.cleancode.service;

/**
 * Some audit service to be used by aspect.
 */
public interface AuditService {
    /**
     * Audit operation.
     * @param group some group
     * @param info some info
     */
    void auditOperation(String group, String info);
}
