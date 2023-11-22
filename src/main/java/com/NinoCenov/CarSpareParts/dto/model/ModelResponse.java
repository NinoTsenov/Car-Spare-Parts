package com.NinoCenov.CarSpareParts.dto.model;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelResponse {


    private Long id;


    private String model;


    private String makeName;
}
