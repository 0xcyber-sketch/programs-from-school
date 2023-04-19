package org.acme.ressource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCarDTO {

    private final String type;
    private final String model;
    private final int productionYear;
    private final String status;

    @JsonCreator
    public CreateCarDTO(
            @JsonProperty("type") String type,
            @JsonProperty("model") String model,
            @JsonProperty("productionYear") int productionYear,
            @JsonProperty("status") String status) {

        this.type = type;
        this.model = model;
        this.productionYear = productionYear;
        this.status = status;

    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getStatus() {
        return status;
    }

}
