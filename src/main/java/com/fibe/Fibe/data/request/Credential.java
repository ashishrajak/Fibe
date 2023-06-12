package com.fibe.Fibe.data.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Credential {
    @NotNull(message = "field not be blank username")
            @NotBlank(message = "field not be blank username")
    String username;
    @NotNull(message = "field not be blank password")
            @NotBlank(message = "field not be blank password")
    String password;
    @NotNull(message = "field not be blank applicationName")
            @NotBlank(message = "field not be applicationName")
    String applicationName;






}
