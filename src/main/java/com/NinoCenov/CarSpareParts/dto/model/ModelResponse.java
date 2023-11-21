package com.NinoCenov.CarSpareParts.dto.model;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelResponse {


    private Long id;

    @NotBlank
    private String model;


    private String make;
}
