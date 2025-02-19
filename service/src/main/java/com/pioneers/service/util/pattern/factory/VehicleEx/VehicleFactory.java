package com.pioneers.service.util.pattern.factory.VehicleEx;

import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {
    public Vehicle getVehicle(String type) {
        return switch (type.toLowerCase()) {

            /* // with bad switch
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            case "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Invalid vehicle type:" + type);*/

            // with enhanced switch
            case "car" -> new Car();
            case "bike" -> new Bike();
            case "truck" -> new Truck();
            default -> throw new IllegalArgumentException("Invalid vehicle type: " + type);
        };
    }
}
