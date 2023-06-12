package com.fibe.Fibe.data.request.lead;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Finance {
    @NotBlank(message =  "provide  PAN")
    String pan;
}
