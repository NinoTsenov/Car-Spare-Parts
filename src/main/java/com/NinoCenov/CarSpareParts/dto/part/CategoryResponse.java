package com.NinoCenov.CarSpareParts.dto.part;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponse {

    @NotNull
    private Long id;

    @NotBlank
    private String categoryName;

    @NotBlank
    private String categoryDescription;
}
