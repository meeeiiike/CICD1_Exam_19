package ie.atu.exam.controller;

import ie.atu.exam.errorHandling.BookingNotFoundException;
import ie.atu.exam.model.VehicleBooking;
import ie.atu.exam.service.VehicleBookingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class VehicleBookingController {
    private final VehicleBookingService vehicleBookingService;
    public VehicleBookingController(VehicleBookingService vehicleBookingService) {
        this.vehicleBookingService = vehicleBookingService;
    }

    @GetMapping("/{regNumber}")
    public ResponseEntity<VehicleBooking> getVehicleBooking(@Valid @PathVariable String regNumber) {
        Optional<VehicleBooking> foundVehicleBooking = vehicleBookingService.findByRegNumber(regNumber);
        if (foundVehicleBooking.isEmpty()) {
            throw new BookingNotFoundException("[WARNING] Booking Not Found!");
        }
        else{
            return ResponseEntity.ok(foundVehicleBooking.get());
        }
    }

    @PostMapping
    public ResponseEntity<VehicleBooking> createVehicleBooking(@Valid @RequestBody VehicleBooking vehicleBooking) {
        VehicleBooking newVehicleBooking = vehicleBookingService.create(vehicleBooking);
        return ResponseEntity.ok(newVehicleBooking);
    }


    @PutMapping("/{regNumber}")
    public ResponseEntity<VehicleBooking> update(@Valid @PathVariable String regNumber, @RequestBody VehicleBooking vehicleBooking) {
        Optional<VehicleBooking> foundVehicleBooking = vehicleBookingService.findByRegNumber(regNumber);
        if(foundVehicleBooking.isEmpty()){
            throw new BookingNotFoundException("[WARNING] Booking Not Found!");
        }
        else{
            VehicleBooking updatedVehicleBooking = vehicleBookingService.update(vehicleBooking);
            return ResponseEntity.ok(updatedVehicleBooking);
        }
    }
    @DeleteMapping("/{regNumber}")
    public ResponseEntity<VehicleBooking> delete(@Valid @PathVariable String regNumber) {
        Optional<VehicleBooking> foundVehicleBooking = vehicleBookingService.findByRegNumber(regNumber);
        if(foundVehicleBooking.isEmpty()){
            throw new BookingNotFoundException("[WARNING] Booking Not Found!");
        }
        else{
            VehicleBooking updatedVehicleBooking = vehicleBookingService.delete(foundVehicleBooking.get());
            return ResponseEntity.ok(updatedVehicleBooking);
        }
    }
}
