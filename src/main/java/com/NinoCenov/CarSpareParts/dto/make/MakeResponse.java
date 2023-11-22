package com.NinoCenov.CarSpareParts.dto.make;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MakeResponse {

    private Long id;

    @NotBlank
    private String makeName;
}
