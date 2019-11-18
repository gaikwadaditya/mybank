package com.mywork.Model;

/**
 * Specifies the status of the payment information group.
 */
public enum PaymentStatusCode {

    ACCEPTEDSETTLEMENTCOMPLETED("AcceptedSettlementCompleted"),

    ACCEPTEDSETTLEMENTINPROCESS("AcceptedSettlementInProcess"),

    PENDING("Pending"),

    REJECTED("Rejected");

    private String value;

    PaymentStatusCode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static PaymentStatusCode fromValue(String text) {
        for (PaymentStatusCode b : PaymentStatusCode.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}


