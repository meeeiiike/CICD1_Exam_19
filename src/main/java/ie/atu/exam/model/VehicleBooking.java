package ie.atu.exam.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class VehicleBooking {
    @NotBlank
    private String driverName;
    @Pattern(regexp = "[0-9]{2,3}-[A-Z]{1,2}-[0-9]{1,6}")
    private String regNumber;
    @Email
    private String email;
    @Min(1)@Max(8)
    private int passengers;
}
