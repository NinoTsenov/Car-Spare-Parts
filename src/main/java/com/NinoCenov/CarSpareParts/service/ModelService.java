package com.NinoCenov.CarSpareParts.service;
import com.NinoCenov.CarSpareParts.dto.part.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.part.model.ModelResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;

import java.util.List;


public interface ModelService {
    List<ModelResponse> findAllModelsByMaker(Make make);
    ModelResponse createModel(ModelRequest request);
    void deleteModelById(Long id);
    ModelResponse updateModel(Long id, ModelRequest request);
    ModelResponse findModelById(Long id);
}
