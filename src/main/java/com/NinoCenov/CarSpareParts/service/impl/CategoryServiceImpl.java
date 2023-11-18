package com.NinoCenov.CarSpareParts.service.impl;

import com.NinoCenov.CarSpareParts.converter.CategoryConverter;
import com.NinoCenov.CarSpareParts.dto.part.CategoryRequest;
import com.NinoCenov.CarSpareParts.dto.part.CategoryResponse;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import com.NinoCenov.CarSpareParts.exeptions.CategoryNotFoundException;
import com.NinoCenov.CarSpareParts.repository.category.CategoryRepository;
import com.NinoCenov.CarSpareParts.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryConverter converter;



    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        Category category = converter.createCategory(request);
        Category savedCategory = repository.save(category);
        return converter.toCategoryResponse(savedCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        repository.deleteById(id);
    }

}
