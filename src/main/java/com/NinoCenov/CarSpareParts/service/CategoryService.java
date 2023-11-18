package com.NinoCenov.CarSpareParts.service;
import com.NinoCenov.CarSpareParts.dto.part.CategoryRequest;
import com.NinoCenov.CarSpareParts.dto.part.CategoryResponse;


public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest request);
    void deleteCategoryById(Long id);

}
