package com.mywork.business;

import com.mywork.model.Domestic1OffPaymentRequest;

public class PreValidation {

    private Domestic1OffPaymentRequest domestic1OffPaymentRequest;

    public PreValidation(Domestic1OffPaymentRequest domestic1OffPaymentRequest) {
        this.domestic1OffPaymentRequest = domestic1OffPaymentRequest;
    }

    public void performValidationChecks() {
        System.out.println("Placeholder for performing Pre Validation Checks...");
    }
}
