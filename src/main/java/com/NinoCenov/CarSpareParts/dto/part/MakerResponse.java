package com.NinoCenov.CarSpareParts.dto.part;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MakerResponse {

    private Long id;

    @NotEmpty()
    private String makerName;
}
