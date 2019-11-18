package com.mywork.service;

import com.mywork.model.Domestic1OffPaymentRequest;

public interface Domestic1OffPaymentService {

    public Domestic1OffPaymentRequest processDomestic1OffPaymentRequest(Domestic1OffPaymentRequest domestic1OffPaymentRequest);

    public Domestic1OffPaymentRequest getDomestic1OffPaymentRequest(String paymentId);

}
