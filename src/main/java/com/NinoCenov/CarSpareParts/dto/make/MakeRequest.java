package com.NinoCenov.CarSpareParts.dto.make;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MakeRequest {

    @NotBlank
    private String makeName;
}
