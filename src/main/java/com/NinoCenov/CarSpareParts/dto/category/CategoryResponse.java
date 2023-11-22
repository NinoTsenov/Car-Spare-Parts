package com.NinoCenov.CarSpareParts.dto.category;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponse {


    private Long id;

    @NotBlank
    private String categoryName;

    @NotBlank
    private String categoryDescription;
}
