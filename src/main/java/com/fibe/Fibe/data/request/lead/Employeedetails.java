package com.fibe.Fibe.data.request.lead;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Employeedetails {
    String employername;
    String officeaddress;
    String officeCity;
    @NotNull(message = "provice  office PIN code")

    int officepincode;
    @NotNull(message = "provice  salary")
            @NotBlank(message = "provice  salary")
    String salary;
}
