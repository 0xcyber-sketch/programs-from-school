package com.howard.resource.customer.dto;

public class SsnDTO {
    private final String ssn;

    public SsnDTO(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }
}
