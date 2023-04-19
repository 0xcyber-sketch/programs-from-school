package com.howard.resource.customer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCustomerDTO {
    private String ssn;
    private String firstName;
    private String lastName;

    @JsonCreator
    public CreateCustomerDTO(@JsonProperty("ssn") String ssn, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
