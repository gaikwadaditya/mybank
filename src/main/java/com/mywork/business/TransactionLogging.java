package com.mywork.Business;

import com.mywork.Model.Domestic1OffPaymentRequest;

public class TransactionLogging {

    private Domestic1OffPaymentRequest domestic1OffPaymentRequest;

    public TransactionLogging(Domestic1OffPaymentRequest domestic1OffPaymentRequest) {
        this.domestic1OffPaymentRequest = domestic1OffPaymentRequest;
    }

    public void log() {
        System.out.println("Placeholder for Transaction Logging...");
    }
}
