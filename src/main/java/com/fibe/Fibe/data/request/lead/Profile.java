package com.fibe.Fibe.data.request.lead;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Profile {
    @NotNull(message = "provice  fname")
    @NotBlank(message =  "provide  fname")
    String firstname;
    @NotBlank(message =  "provide  lname")
    @NotNull(message = "provice  lname")
    String lastname;
    @NotBlank(message =  "provide dob")
    @NotNull(message = "provice  DoB")
    String dob;
    @NotBlank(message =  "provide  email")
    @NotNull(message = "provice  email")
    String emailid;
    @NotBlank(message =  "provide profession")
    @NotNull(message = "provice profession")
    String profession;
    String address1;
    String address2;
    String landmark;
    String city;
    @NotNull(message = "provice PIN")
    int pincode;
    String maritalstatus;
    String subSource;






}
