package com.NinoCenov.CarSpareParts.service.impl;
import com.NinoCenov.CarSpareParts.converter.ModelConverter;
import com.NinoCenov.CarSpareParts.dto.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
import com.NinoCenov.CarSpareParts.dto.model.ModelUpdateDTO;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.exceptions.ModelNotFoundException;
import com.NinoCenov.CarSpareParts.repository.MakeRepository;
import com.NinoCenov.CarSpareParts.repository.ModelRepository;
import com.NinoCenov.CarSpareParts.service.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelConverter modelConverter;
    private final MakeRepository makeRepository;

    @Override
    public List<ModelResponse> findAllModelsByMake(Make make) {
        List<Model> allModels = modelRepository.findByMake(make);
        List<ModelResponse>sortedModelsByMake=new ArrayList<>();
        for(Model model: allModels){
            {
                ModelResponse foundModel = modelConverter.toModelResponse(model);
                sortedModelsByMake.add(foundModel);
            }
        }
        return sortedModelsByMake;
    }

    @Override
    public ModelResponse createModel(ModelRequest request) {
        Model model = modelConverter.createModel(request);
        Model savedModel = modelRepository.save(model);
        return modelConverter.toModelResponse(savedModel);
    }

    @Override
    public void deleteModelById(Long id) {
        modelRepository.deleteById(id);
    }

    @Override
    public ModelResponse updateModel(Long id, ModelUpdateDTO request) {
        Model model = modelRepository.findById(id).orElseThrow(
                ()-> new ModelNotFoundException("This model was not found !"));

        Make make = new Make();
        make.setId(request.getMake().getId());
        make.setName(request.getMake().getMakeName());

        if (make.getId() == null) {
            makeRepository.save(make);
        }

        model.setName(request.getName());
        model.setMake(make);
        Model updatedModel = modelRepository.save(model);
        return modelConverter.toModelResponse(updatedModel);
    }

    @Override
    public ModelResponse findModelById(Long id) {
        Model model = modelRepository.findById(id).orElseThrow(()-> new ModelNotFoundException("This model was not found !"));

        return modelConverter.toModelResponse(model);
    }

    @Override
    public List<ModelResponse> findAll() {
        List<Model> makeList = modelRepository.findAll();
        List<ModelResponse> modelResponses = new ArrayList<>();

        for (Model model : makeList) {
            ModelResponse response = modelConverter.toModelResponse(model);
            modelResponses.add(response);
        }

        return modelResponses;
    }
}
