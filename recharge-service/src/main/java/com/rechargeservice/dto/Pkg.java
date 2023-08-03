package com.rechargeservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pkg {
    @NotNull(message = "Number can not be empty")
    @Pattern(regexp = "^\\d{9}$", message = "Invalid mobile number")
    private String number;
    @NotNull(message = "Amount can not be empty")
    @Pattern(regexp = "^\\d{3}$", message = "Invalid amount")
    private String amount;
}
