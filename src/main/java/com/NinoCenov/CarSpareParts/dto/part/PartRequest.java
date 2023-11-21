package com.NinoCenov.CarSpareParts.dto.part;
import com.NinoCenov.CarSpareParts.entity.category.Category;
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
public class PartRequest {

    @NotBlank()
    private String partName;

    @NotBlank()
    private String partDescription;

    @NotNull()
    private Double price;

    @NotNull()
    private Category category;

    @NotNull()
    private List<Model> models;
}
