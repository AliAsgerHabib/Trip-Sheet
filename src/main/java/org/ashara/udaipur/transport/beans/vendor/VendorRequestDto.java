package org.ashara.udaipur.transport.beans.vendor;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VendorRequestDto {
    @NotBlank(message = "Vendor name should not be blank")
    private String name;

    @NotBlank(message = "City should not be blank")
    private String registeredCity;

    @NotBlank(message = "Country should not be blank")
    private String registeredCountry;

    @NotBlank(message = "Contact Person Name should not be blank")
    private String contactPersonName;

    @NotBlank
    @Pattern(regexp = "^\\+\\d{1,3}-\\d{10}$", message = "Invalid phone number format. Expected +<country-code>-XXXXXXXXXX")
    private String contactPersonNo;

    @Email
    private String contactPersonEmail;
}
