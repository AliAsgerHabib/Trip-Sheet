package org.ashara.udaipur.transport.beans.bus;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BusRequestDto {
    @Pattern(
            regexp = "^[A-Z]{2}[0-9]{1,2}[A-Z]{1,3}[0-9]{1,4}$",
            message = "Invalid vehicle number format"
    )
    private String registrationNo;

    @NotNull(message = "Vendor Should not be null.")
    private Integer vendorId;

    @NotBlank(message = "Driver Name should not be blank")
    private String driverName;

    @NotBlank(message = "Contact No should not be blank")
    @Pattern(regexp = "^\\+\\d{1,3}-\\d{10}$", message = "Invalid phone number format. Expected +<country-code>-XXXXXXXXXX")
    private String driverContactNo;

    @Min(value = 0, message = "Should be greater than zero")
    @Max(value = 100, message = "Should not exceed 100")
    private Integer maxCapacity;

    @NotNull(message = "Pickup and Drop Off Points should not be null.")
    private Integer pickUpPointId;

    @NotNull(message = "Pickup and Drop Off Points should not be null.")
    private Integer dropOffPointId;
}