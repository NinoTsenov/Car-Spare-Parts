package com.NinoCenov.CarSpareParts.dto.part;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PartResponse {

    private Long id;

    @NotBlank()
    private String partName;

    @NotBlank()
    private String partDescription;

    @NotNull()
    private Double price;

    @NotNull()
    private String category;

    @NotNull
    private List<Model> models;
}
