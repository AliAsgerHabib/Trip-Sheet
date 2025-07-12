package org.ashara.udaipur.transport.beans.vendor;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VendorDto {
    private Integer vendorId;
    private String name;
    private String registeredCity;
    private String registeredCountry;
    private String contactPersonName;
    private String contactPersonEmail;
    private String contactPersonNo;
}
