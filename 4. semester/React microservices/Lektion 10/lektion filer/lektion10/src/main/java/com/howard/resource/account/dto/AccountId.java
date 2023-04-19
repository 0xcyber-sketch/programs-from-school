package com.howard.resource.account.dto;

public class AccountId {
    private final int regNumber;
    private final String accountNumber;

    public AccountId(int regNumber, String accountNumber) {
        this.regNumber = regNumber;
        this.accountNumber = accountNumber;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
