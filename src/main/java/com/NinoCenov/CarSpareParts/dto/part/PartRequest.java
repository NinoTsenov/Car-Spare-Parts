package com.NinoCenov.CarSpareParts.dto.part;
import com.NinoCenov.CarSpareParts.dto.model.ModelRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PartRequest {

    @NotBlank
    @Size(min = 2)
    private String partName;

    @NotBlank
    @Size(max = 255)
    private String partDescription;

    @NotNull
    private Double price;


    private Long categoryId;


    private List<ModelRequest> models;
}
