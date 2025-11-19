package ie.atu.exam.controller;

import ie.atu.exam.service.VehicleBookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class VehicleBookingController {
    private final VehicleBookingService vehicleBookingService;
    public VehicleBookingController(VehicleBookingService vehicleBookingService) {
        this.vehicleBookingService = vehicleBookingService;
    }

    /*
    @GetMapping("/{regNumber}")
    public

     */
}
