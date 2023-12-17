package com.NinoCenov.CarSpareParts.dto.make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String makeName;

    @JsonIgnore
    private List<Model> modelList;

    private List<String> modelNames;


}
