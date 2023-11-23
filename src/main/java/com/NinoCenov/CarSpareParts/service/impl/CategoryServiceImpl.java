package com.NinoCenov.CarSpareParts.service.impl;

import com.NinoCenov.CarSpareParts.converter.CategoryConverter;
import com.NinoCenov.CarSpareParts.dto.category.CategoryRequest;
import com.NinoCenov.CarSpareParts.dto.category.CategoryResponse;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import com.NinoCenov.CarSpareParts.repository.CategoryRepository;
import com.NinoCenov.CarSpareParts.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        Category category = categoryConverter.createCategory(request);
        Category savedCategory = categoryRepository.save(category);
        return categoryConverter.toCategoryResponse(savedCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponse> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryResponse> responses = new ArrayList<>();

        for (Category c : categoryList) {
            CategoryResponse response = categoryConverter.toCategoryResponse(c);
            responses.add(response);
        }
        return responses;
    }

}
