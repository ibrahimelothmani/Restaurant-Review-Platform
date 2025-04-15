package com.ibrahim.platform.domain.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TimeRangeDto {

    @NotBlank(message = "Open time cannot be blank")
    @Pattern(regexp = "^(0[0-9]|1[0-2]):[0-5][0-9] (AM|PM)$", message = "Open time must be in the format HH:MM AM/PM")
    private String openTime;

    @NotBlank(message = "Close time cannot be blank")
    @Pattern(regexp = "^(0[0-9]|1[0-2]):[0-5][0-9] (AM|PM)$", message = "Open time must be in the format HH:MM AM/PM")
    private String closeTime;
}
