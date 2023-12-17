package com.NinoCenov.CarSpareParts.service;
import com.NinoCenov.CarSpareParts.dto.part.PartRequest;
import com.NinoCenov.CarSpareParts.dto.part.PartResponse;


import java.util.List;

public interface PartService {
    PartResponse createPart(PartRequest request);
    PartResponse updatePart(Long id, PartRequest request);
    void deletePartById(Long id);
    List<PartResponse> getAllAvailableParts();
    PartResponse getPartById(Long id);
    List<PartResponse>getAllPartsByCategoryAndModel(Long categoryId, String model);
    List<PartResponse>getAllPartsByCategory(Long categoryId);
    List<PartResponse>getAllPartsInAllCategoriesByPartName(String partName);
}
