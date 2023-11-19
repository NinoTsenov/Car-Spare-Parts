package com.NinoCenov.CarSpareParts.converter;

import com.NinoCenov.CarSpareParts.dto.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.exeptions.MakeNotFoundException;
import com.NinoCenov.CarSpareParts.repository.MakeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ModelConverter {
    private final MakeRepository repository;

    public Model createModel(ModelRequest request){

        Make make = repository.findByName(request.getMake()).orElseThrow(
                ()-> new MakeNotFoundException("This make is missing"));

        return Model.builder()
                .model(request.getModel())
                .make(make)
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
