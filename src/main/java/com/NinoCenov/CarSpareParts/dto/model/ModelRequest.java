package com.NinoCenov.CarSpareParts.dto.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelRequest {

    private Long id;

    @NotBlank
    @Size(min = 2)
    private String modelName;

    private String makeName;
}
