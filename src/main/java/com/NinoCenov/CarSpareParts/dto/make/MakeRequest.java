package com.NinoCenov.CarSpareParts.dto.make;
import jakarta.validation.constraints.NotEmpty;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MakeRequest {

    @NotEmpty()
    private String make;
}
