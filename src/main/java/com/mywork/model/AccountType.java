package com.mywork.model;

public enum AccountType {

    BUSINESS("business"),

    PERSONAL("Personal");

    private String value;

    AccountType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static AccountType fromValue(String text) {
        for (AccountType b : AccountType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}



