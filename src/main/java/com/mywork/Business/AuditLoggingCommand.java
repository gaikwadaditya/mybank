package com.mywork.Business;

public class AuditLoggingCommand implements Command {

    private AuditLogging auditLogging;

    public AuditLoggingCommand(AuditLogging auditLogging) {
        this.auditLogging = auditLogging;
    }

    @Override
    public void execute() {
        auditLogging.log();
    }
}
