package com.NinoCenov.CarSpareParts.converter;
import com.NinoCenov.CarSpareParts.dto.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
import com.NinoCenov.CarSpareParts.dto.part.PartRequest;
import com.NinoCenov.CarSpareParts.dto.part.PartResponse;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.entity.part.Part;
import com.NinoCenov.CarSpareParts.exceptions.CategoryNotFoundException;
import com.NinoCenov.CarSpareParts.repository.CategoryRepository;
import com.NinoCenov.CarSpareParts.repository.MakeRepository;
import com.NinoCenov.CarSpareParts.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PartConverter {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;
    private final ModelRepository modelRepository;
    private final ModelConverter modelConverter;
    private final MakeRepository makeRepository;

    public Part createPart (PartRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(
                () -> new CategoryNotFoundException("This category is missing"));
        List<ModelRequest> modelRequests = request.getModels();
        List<Model> models = new ArrayList<>();

        for (ModelRequest modelRequest : modelRequests) {
            String modelName = modelRequest.getModelName();
            String makeName = modelRequest.getMakeName();

            Make make = makeRepository.findByName(makeName);

            if (make == null) {
                make = makeRepository.save(Make.builder().name(makeName).build());
            }

            Model model = Model.builder()
                    .modelName(modelName)
                    .make(make)
                    .build();

            model = modelRepository.save(model);

            models.add(model);
        }
        return Part.builder()
                .partName(request.getPartName())
                .partDescription(request.getPartDescription())
                .price(request.getPrice())
                .category(category)
                .models(models)
                .build();
    }

    public PartResponse toPartResponse(Part part) {
        List<ModelResponse> modelResponses = new ArrayList<>();

        for (Model model : part.getModels()) {
            ModelResponse modelResponse = modelConverter.toModelResponse(model);
            modelResponses.add(modelResponse);
        }

        return PartResponse.builder()
                .id(part.getId())
                .partName(part.getPartName())
                .partDescription(part.getPartDescription())
                .price(part.getPrice())
                .category(categoryConverter.toCategoryResponse(part.getCategory()))
                .models(modelResponses)
                .build();
    }
}


