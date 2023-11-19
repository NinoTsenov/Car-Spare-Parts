package com.NinoCenov.CarSpareParts.service;
import com.NinoCenov.CarSpareParts.dto.category.CategoryRequest;
import com.NinoCenov.CarSpareParts.dto.category.CategoryResponse;


public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest request);
    void deleteCategoryById(Long id);
//those methods are not in the task, but need them for testing
}
