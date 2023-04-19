package org.acme.ressource.dto;

import java.util.Objects;

public class CarDTO {
    private final String serialNumber;
    private final String status;
    private final String type;
    private final String model;
    private final int productionYear;

    public CarDTO(String serialNumber, String type, String model, int productionYear, String status) {
        this.type = type;
        this.model = model;
        this.productionYear = productionYear;
        this.status = status;
        this.serialNumber = serialNumber;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDTO carDTO = (CarDTO) o;
        return Objects.equals(serialNumber, carDTO.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }
}
