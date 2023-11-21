package com.NinoCenov.CarSpareParts.service.impl;
import com.NinoCenov.CarSpareParts.converter.PartConverter;
import com.NinoCenov.CarSpareParts.dto.part.PartRequest;
import com.NinoCenov.CarSpareParts.dto.part.PartResponse;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.entity.part.Part;
import com.NinoCenov.CarSpareParts.exceptions.CategoryNotFoundException;
import com.NinoCenov.CarSpareParts.exceptions.ModelNotFoundException;
import com.NinoCenov.CarSpareParts.exceptions.PartNotFoundException;
import com.NinoCenov.CarSpareParts.repository.CategoryRepository;
import com.NinoCenov.CarSpareParts.repository.ModelRepository;
import com.NinoCenov.CarSpareParts.repository.PartRepository;
import com.NinoCenov.CarSpareParts.service.PartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final PartConverter partConverter;
    private final CategoryRepository categoryRepository;
    private final ModelRepository modelRepository;

    @Override
    public PartResponse createPart(PartRequest request) {
        Part part = partConverter.createPart(request);
        Part savedPart = partRepository.save(part);
        return partConverter.toPartResponse(savedPart);
    }

    @Override
    public PartResponse updatePart(Long id, PartRequest request) {
        Part part = partRepository.findById(id).orElseThrow(()-> new PartNotFoundException("Part was not found"));
        part.setPartName(request.getPartName());
        part.setPartDescription(request.getPartDescription());
        part.setCategory(request.getCategory());
        part.setPrice(request.getPrice());
        part.setModels(request.getModels());

        Part updatedPart = partRepository.save(part);

        return partConverter.toPartResponse(updatedPart);
    }

    @Override
    public void deletePartById(Long id) {
    partRepository.deleteById(id);
    }

    @Override
    public List<PartResponse> getAllAvailableParts() {
        List<Part> allParts = partRepository.findAll();
        return allParts.stream().map(partConverter::toPartResponse).toList();
    }

    @Override
    public PartResponse getPartById(Long id) {
        Part part = partRepository.findById(id).orElseThrow(()-> new PartNotFoundException("Part not found"));
        return partConverter.toPartResponse(part);
    }

    @Override
    public List<PartResponse> getAllPartsByCategoryAndModel(String category, String model) {

        Category foundCategory = categoryRepository.findByCategoryName(category)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found: " + category));



        Model foundModel = modelRepository.findByModel(model)
                .orElseThrow(() -> new ModelNotFoundException("Model not found: " + model));


        List<Part> matchingParts = partRepository.findByCategoryAndModels
                (foundCategory.getCategoryName(), Collections.singletonList(foundModel));

        return matchingParts.stream()
                .map(partConverter::toPartResponse).collect(Collectors.toList());
    }

    @Override
    public List<PartResponse> getAllPartsInAllCategoriesByPartName(String name) {
        List<Part> foundParts = partRepository.findByPartName(name);

        return foundParts.stream().map(partConverter::toPartResponse).collect(Collectors.toList());
    }
}
