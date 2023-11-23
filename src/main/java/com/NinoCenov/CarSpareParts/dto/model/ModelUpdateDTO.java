package com.NinoCenov.CarSpareParts.dto.model;

import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelUpdateDTO {

    @NotBlank
    @Size(min = 2)
    private String name;

    private MakeResponse make;
}
