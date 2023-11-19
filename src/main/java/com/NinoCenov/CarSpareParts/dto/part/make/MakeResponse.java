package com.NinoCenov.CarSpareParts.dto.part.make;

import com.NinoCenov.CarSpareParts.entity.model.Model;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty()
    private String make;

    @NotNull
    private List<Model> model;
}
