package com.mywork.business;

import com.mywork.model.Domestic1OffPaymentRequest;

public class AuditLogging {

    private Domestic1OffPaymentRequest domestic1OffPaymentRequest;

    public AuditLogging(Domestic1OffPaymentRequest domestic1OffPaymentRequest) {
        this.domestic1OffPaymentRequest = domestic1OffPaymentRequest;
    }

    public void log() {
        System.out.println("Placeholder for Audit Logging...");
    }

}
