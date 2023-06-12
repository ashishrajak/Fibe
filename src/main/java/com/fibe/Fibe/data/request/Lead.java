package com.fibe.Fibe.data.request;

import com.fibe.Fibe.data.request.lead.Employeedetails;
import com.fibe.Fibe.data.request.lead.Finance;
import com.fibe.Fibe.data.request.lead.Profile;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Valid
public class Lead {
    @NotNull(message = "provide mobile number")
            @NotBlank(message =  "provide mobile number")
    String mobilenumber;
    @Valid
   Profile profile;
    @Valid
   Finance finance;
    @Valid
   Employeedetails employeedetails;
}
