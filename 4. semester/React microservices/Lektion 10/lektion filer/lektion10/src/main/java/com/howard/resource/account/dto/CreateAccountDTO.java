package com.howard.resource.account.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccountDTO {
    private int regNumber;
    private String accountNumber;
    private String ssn;

    @JsonCreator
    public CreateAccountDTO(
            @JsonProperty("ssn") String ssn,
            @JsonProperty("regNumber") int regNumber,
            @JsonProperty("accountNumber") String accountNumber
    ) {
        this.regNumber = regNumber;
        this.ssn = ssn;
        this.accountNumber = accountNumber;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
