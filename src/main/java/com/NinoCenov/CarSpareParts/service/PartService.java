package com.NinoCenov.CarSpareParts.service;
import com.NinoCenov.CarSpareParts.dto.part.PartRequest;
import com.NinoCenov.CarSpareParts.dto.part.PartResponse;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.entity.category.Category;

import java.util.List;

public interface PartService {
    PartResponse createPart(PartRequest request);
    PartResponse updatePart(Long id, PartRequest request);
    void deletePartById(Long id);
    List<PartResponse> getAllAvailableParts();
    PartResponse getPartById(Long id);
    List<PartResponse>getAllPartsByCategoryAndModels(Long id, Category category, Model model);
    List<PartResponse>getAllPartsInAllCategoriesByName(String partName);
}
