package com.NinoCenov.CarSpareParts.dto.model;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelRequest {

    private String model;

    private Make make;
}
