package org.ashara.udaipur.transport.beans.bus;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusDto {
    private Integer busId;
    private String registrationNo;
    private String driverName;
    private String driverContactNo;
    private Integer maxCapacity;
    private Integer vendorId;
    private String vendorName;
    private Integer pickUpPointId;
    private String pickUpPointName;
    private Integer dropOffPointId;
    private String dropOffPointName;
}