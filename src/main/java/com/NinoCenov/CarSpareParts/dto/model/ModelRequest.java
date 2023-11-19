package com.NinoCenov.CarSpareParts.dto.model;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelRequest {

    @NotEmpty()
    private String model;

    @NotEmpty
    private String make;
}
