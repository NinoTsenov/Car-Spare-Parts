package com.NinoCenov.CarSpareParts.dto.part.category;
import jakarta.validation.constraints.NotBlank;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryRequest {


    @NotBlank
    private String categoryName;

    @NotBlank
    private String categoryDescription;
}
