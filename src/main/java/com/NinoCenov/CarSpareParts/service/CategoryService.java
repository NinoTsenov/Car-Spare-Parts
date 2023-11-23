package com.NinoCenov.CarSpareParts.service;
import com.NinoCenov.CarSpareParts.dto.category.CategoryRequest;
import com.NinoCenov.CarSpareParts.dto.category.CategoryResponse;

import java.util.List;


public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest request);
    void deleteCategoryById(Long id);
    List<CategoryResponse> findAll ();
//those methods are not in the task, but need them for testing
}
