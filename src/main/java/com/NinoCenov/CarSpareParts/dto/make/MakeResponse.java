package com.NinoCenov.CarSpareParts.dto.make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MakeResponse {

    private Long id;

    @NotBlank()
    private String make;

    @NotNull
    private List<Model> model;
}
