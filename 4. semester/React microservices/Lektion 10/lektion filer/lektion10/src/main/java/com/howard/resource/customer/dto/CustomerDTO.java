package com.howard.resource.customer.dto;

public class CustomerDTO {
    private NameDTO name;
    private final SsnDTO ssnDTO;

    public CustomerDTO(NameDTO name, SsnDTO ssnDTO) {
        this.name = name;
        this.ssnDTO = ssnDTO;
    }

    public NameDTO getName() {
        return name;
    }

    public SsnDTO getSsnDTO() {
        return ssnDTO;
    }

    public void setName(NameDTO name) {
        this.name = name;
    }
}
