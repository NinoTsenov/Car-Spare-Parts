package com.NinoCenov.CarSpareParts.converter;
import com.NinoCenov.CarSpareParts.dto.part.PartRequest;
import com.NinoCenov.CarSpareParts.dto.part.PartResponse;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.entity.part.Part;
import com.NinoCenov.CarSpareParts.exceptions.CategoryNotFoundException;
import com.NinoCenov.CarSpareParts.exceptions.ModelNotFoundException;
import com.NinoCenov.CarSpareParts.repository.CategoryRepository;
import com.NinoCenov.CarSpareParts.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PartConverter {

    private final CategoryRepository categoryRepository;
    private final ModelRepository modelRepository;

    public Part createPart (PartRequest request){

        Category category = categoryRepository.findByCategoryName(request.getCategory().getCategoryName()).orElseThrow(
                ()-> new CategoryNotFoundException("This category is missing"));
        List<Model> model = getModelList(request.getModels());

        return Part.builder()
                .partName(request.getPartName())
                .partDescription(request.getPartDescription())
                .price(request.getPrice())
                .category(category)
                .models(model)
                .build();
    }

    public PartResponse toPartResponse(Part part) {
        List<Model> model = getModelList(part.getModels());
        PartResponse response = new PartResponse();
        response.setId(part.getId());
        response.setPartName(part.getPartName());
        response.setPartDescription(part.getPartDescription());
        response.setPrice(part.getPrice());
        response.setCategory(part.getCategory());
        response.setModels(model);
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
