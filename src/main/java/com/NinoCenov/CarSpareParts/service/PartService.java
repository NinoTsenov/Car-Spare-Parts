package com.NinoCenov.CarSpareParts.service;
import com.NinoCenov.CarSpareParts.dto.part.PartResponse;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.entity.category.Category;

import java.util.List;



public interface PartService {
    List<PartResponse> getAllAvailableParts();
    PartResponse getPartById(Long id);
    List<PartResponse>getAllPartsByCategoryAndModels(Long id, Category category, Model model);
    List<PartResponse>getAllPartsInAllCategories(Category category);
}
