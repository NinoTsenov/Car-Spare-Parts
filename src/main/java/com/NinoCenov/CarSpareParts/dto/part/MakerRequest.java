package com.NinoCenov.CarSpareParts.dto.part;
import jakarta.validation.constraints.NotEmpty;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MakerRequest {

    @NotEmpty()
    private String makerName;
}
