package com.NinoCenov.CarSpareParts.service;
import com.NinoCenov.CarSpareParts.dto.part.category.CategoryRequest;
import com.NinoCenov.CarSpareParts.dto.part.category.CategoryResponse;


public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest request);
    void deleteCategoryById(Long id);

}
