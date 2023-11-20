package com.NinoCenov.CarSpareParts.converter;
import com.NinoCenov.CarSpareParts.dto.make.MakeRequest;
import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.exceptions.ModelNotFoundException;
import com.NinoCenov.CarSpareParts.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class MakeConverter {

    private final ModelRepository modelRepository;

    public Make createMake(MakeRequest request) {
        return Make.builder()
                .make(request.getMake())
                .build();
    }

    public MakeResponse toMakeResponse(Make make) {
        List<Model> model = getModelList(make.getModels());
        MakeResponse response = new MakeResponse();
        response.setId(make.getId());
        response.setMake(make.getMake());
        response.setModel(model);
        return response;
    }

    private List<Model> getModelList(List<Model> modelList) {
        List<Model> models = new ArrayList<>();

        for (Model model : modelList) {
            Model model1 = modelRepository.findById(model.getId())
                    .orElseThrow(() -> new ModelNotFoundException("Model was not found: " + model.getId()));
            models.add(model1);
        }
        return models;
    }
}
