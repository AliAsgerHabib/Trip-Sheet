package org.ashara.udaipur.transport.beans.vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDetails {
    public String registrationNo;
    public String vendorName;
    public String busType;
    public Integer maxCapacity;
}