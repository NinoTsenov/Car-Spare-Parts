package com.NinoCenov.CarSpareParts.dto.part;
import com.NinoCenov.CarSpareParts.entity.part.Part;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryRequest {
    @NotNull
    private Long id;

    @NotBlank
    private String categoryName;

    @NotBlank
    private String categoryDescription;
}
