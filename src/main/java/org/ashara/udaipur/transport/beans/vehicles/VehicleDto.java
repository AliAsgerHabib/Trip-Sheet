package org.ashara.udaipur.transport.beans.vehicles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDto {
    private Integer id;
    private String registrationNo;
    private String vendorName;
    private String vehicleType;
    private Integer maxCapacity;
    private String driverName;
    private String driverContactNo;
}