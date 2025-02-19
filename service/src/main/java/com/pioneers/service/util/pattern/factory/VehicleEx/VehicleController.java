package com.pioneers.service.util.pattern.factory.VehicleEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleFactory vehicleFactory;

    @PostMapping("/drive")
    public String getVehicle(String type) {

        /*Vehicle vehicle = vehicleFactory.getVehicle(type);
        return vehicle.drive();*/

        return vehicleFactory.getVehicle(type).drive();
    }

}
