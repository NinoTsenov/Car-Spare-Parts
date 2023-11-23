package com.NinoCenov.CarSpareParts.dto.part;
import com.NinoCenov.CarSpareParts.dto.category.CategoryResponse;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
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

    @NotBlank
    private String partName;

    @NotBlank
    private String partDescription;

    @NotNull
    private Double price;


    private CategoryResponse category;


    private List<ModelResponse> models;
}
