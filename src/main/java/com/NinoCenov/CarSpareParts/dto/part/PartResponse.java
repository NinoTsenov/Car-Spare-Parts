package com.NinoCenov.CarSpareParts.dto.part;

import com.NinoCenov.CarSpareParts.entity.category.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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

    @NotBlank()
    private Category category;
}
