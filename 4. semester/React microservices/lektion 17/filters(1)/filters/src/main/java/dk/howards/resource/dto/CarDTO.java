package dk.howards.resource.dto;

public class CarDTO {
    private final String registration;
    private final String make;
    private final String model;
    private final int year;

    public CarDTO(String registration, String make, String model, int year) {
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getRegistration() {
        return registration;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}
