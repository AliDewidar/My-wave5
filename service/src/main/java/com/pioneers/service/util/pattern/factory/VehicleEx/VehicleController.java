package com.pioneers.service.util.pattern.factory.VehicleEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleFactory vehicleFactory;

    @PostMapping("/drive/{type}")
    public String getVehicle(@PathVariable String type) {

        /*Vehicle vehicle = vehicleFactory.getVehicle(type);
        return vehicle.drive();*/

        return vehicleFactory.getVehicle(type).drive();
    }

}
