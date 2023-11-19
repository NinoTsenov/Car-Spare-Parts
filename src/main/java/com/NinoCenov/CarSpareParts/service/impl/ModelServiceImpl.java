package com.NinoCenov.CarSpareParts.service.impl;

import com.NinoCenov.CarSpareParts.converter.ModelConverter;
import com.NinoCenov.CarSpareParts.dto.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.exeptions.ModelNotFoundException;
import com.NinoCenov.CarSpareParts.repository.ModelRepository;
import com.NinoCenov.CarSpareParts.service.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository repository;
    private final ModelConverter converter;

    @Override
    public List<ModelResponse> findAllModelsByMaker(Make make) {
        List<Model> allModels = repository.findAll();
        List<ModelResponse>sortedModelsByMaker=new ArrayList<>();
        for(Model model: allModels){
            if(model.getMake().equals(make)){
                ModelResponse foundModel = converter.toModelResponse(model);
                sortedModelsByMaker.add(foundModel);
            }
        }
        return sortedModelsByMaker;
    }

    @Override
    public ModelResponse createModel(ModelRequest request) {
        Model model = converter.createModel(request);
        Model savedModel = repository.save(model);
        return converter.toModelResponse(savedModel);
    }

    @Override
    public void deleteModelById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ModelResponse updateModel(Long id, ModelRequest request) {
        Model model = repository.findById(id).orElseThrow(()-> new ModelNotFoundException("This model was not found !"));
        model.setModel(request.getModel());
        Model updatedModel = repository.save(model);
        return converter.toModelResponse(updatedModel);
    }

    @Override
    public ModelResponse findModelById(Long id) {
        Model model = repository.findById(id).orElseThrow(()-> new ModelNotFoundException("This model was not found !"));

        return converter.toModelResponse(model);
    }
}
