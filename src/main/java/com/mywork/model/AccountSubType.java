package com.mywork.model;

public enum AccountSubType {

    CHARGECARD("ChargeCard"),

    CREDITCARD("CreditCard"),

    CURRENTACCOUNT("CurrentAccount"),

    EMONEY("EMoney"),

    LOAN("Loan"),

    MORTGAGE("Mortgage"),

    PREPAIDCARD("PrePaidCard"),

    SAVINGS("Savings");

    private String value;

    AccountSubType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static AccountSubType fromValue(String text) {
        for (AccountSubType b : AccountSubType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}


