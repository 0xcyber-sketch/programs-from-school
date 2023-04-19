package com.howard.resource.account.dto;

import com.howard.resource.customer.dto.CustomerDTO;

public class AccountDTO {
    private final AccountId id;
    private final CustomerDTO customer;


    public AccountDTO(AccountId id, CustomerDTO customer) {
        this.id = id;
        this.customer = customer;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public AccountId getId() {
        return id;
    }
}
