package org.ashara.udaipur.transport.beans.point;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PointRequestDto {
    @NotBlank(message = "Point name should not be blank")
    private String name;

    @NotBlank(message = "Name should not be blank")
    private String zonalHeadName;

    @NotBlank
    @Pattern(regexp = "^\\+\\d{1,3}-\\d{10}$", message = "Invalid phone number format. Expected +<country-code>-XXXXXXXXXX")
    private String zonalHeadContactNo;

    @Email
    private String zonalHeadEmail;
}
