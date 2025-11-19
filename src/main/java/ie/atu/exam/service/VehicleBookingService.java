package ie.atu.exam.service;

import ie.atu.exam.errorHandling.BookingNotFoundException;
import ie.atu.exam.errorHandling.DuplicateRegNumberException;
import ie.atu.exam.model.VehicleBooking;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleBookingService {

    private final List<VehicleBooking> vehicleBookingList = new ArrayList<>();

    // Defensive Copy
    public List<VehicleBooking> getList(){
        return new ArrayList<>(vehicleBookingList);
    }

    public Optional<VehicleBooking> findByRegNumber(String regNumber){
        for (VehicleBooking vehicleBooking : vehicleBookingList){
            if(vehicleBooking.getRegNumber().equals(regNumber)){
                return Optional.of(vehicleBooking);
            }
        }
        return Optional.empty();
    }

    public VehicleBooking create(VehicleBooking vehicleBooking) {
        if(findByRegNumber(vehicleBooking.getRegNumber()).isPresent()){
            throw new DuplicateRegNumberException("[WARNING] Id Already Exists!");
        }
        vehicleBookingList.add(vehicleBooking);
        return vehicleBooking;
    }

    public VehicleBooking update(VehicleBooking vehicleBooking) {
        for(VehicleBooking updating : vehicleBookingList){
            if(updating.getRegNumber().equals(vehicleBooking.getRegNumber())){
                updating.setDriverName(vehicleBooking.getDriverName());
                updating.setEmail(vehicleBooking.getEmail());
                updating.setPassengers(vehicleBooking.getPassengers());
                return updating;
            }
        }
        throw new BookingNotFoundException("[WARNING] Booking Not Found!");
    }

    public VehicleBooking delete(VehicleBooking vehicleBooking) {
        boolean exists = findByRegNumber(vehicleBooking.getRegNumber()).isPresent();
        if(exists){
            vehicleBookingList.remove(vehicleBooking);
        }
        if(!exists){
            throw new BookingNotFoundException("[WARNING] Booking Not Found!");
        }
        return vehicleBooking;
    }

}
