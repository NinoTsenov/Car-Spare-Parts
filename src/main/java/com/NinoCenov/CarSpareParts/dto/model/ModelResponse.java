package com.NinoCenov.CarSpareParts.dto.model;
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
