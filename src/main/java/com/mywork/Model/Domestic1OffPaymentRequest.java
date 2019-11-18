package com.mywork.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Domestic1OffPaymentRequest {

    @JsonProperty("PaymentId")
    private String paymentId;

    @JsonProperty("CreditorAccount")
    private Account creditorAccount;

    @JsonProperty("DebitorAccount")
    private Account debitorAccount;

    @JsonProperty("InstructedAmount")
    private InstructedAmount instructedAmount;

    @JsonProperty("PaymentStatus")
    private PaymentStatusCode statusCode;

    public Domestic1OffPaymentRequest() {
    }

    public Domestic1OffPaymentRequest(Account creditorAccount, Account debitorAccount, InstructedAmount instructedAmount) {
        this.creditorAccount = creditorAccount;
        this.debitorAccount = debitorAccount;
        this.instructedAmount = instructedAmount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Account getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(Account creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

    public Account getDebitorAccount() {
        return debitorAccount;
    }

    public void setDebitorAccount(Account debitorAccount) {
        this.debitorAccount = debitorAccount;
    }

    public InstructedAmount getInstructedAmount() {
        return instructedAmount;
    }

    public void setInstructedAmount(InstructedAmount instructedAmount) {
        this.instructedAmount = instructedAmount;
    }

    public PaymentStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(PaymentStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Domestic1OffPaymentRequest{" +
                "paymentId='" + paymentId + '\'' +
                ", creditorAccount=" + creditorAccount +
                ", debitorAccount=" + debitorAccount +
                ", instructedAmount=" + instructedAmount +
                ", statusCode=" + statusCode +
                '}';
    }
}
