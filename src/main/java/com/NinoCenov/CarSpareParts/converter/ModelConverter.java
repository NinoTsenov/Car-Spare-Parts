package com.NinoCenov.CarSpareParts.converter;

import com.NinoCenov.CarSpareParts.dto.part.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.part.model.ModelResponse;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import org.springframework.stereotype.Component;

@Component
public class ModelConverter {
    public Model createModel(ModelRequest request){
        return Model.builder()
                .model(request.getModel())
                .make(request.getMake())
                .build();
    }

    public ModelResponse toModelResponse(Model model){
        ModelResponse response = new ModelResponse();
        response.setId(model.getId());
        response.setModel(model.getModel());
        response.setMake(model.getMake());
        return response;
    }
}
