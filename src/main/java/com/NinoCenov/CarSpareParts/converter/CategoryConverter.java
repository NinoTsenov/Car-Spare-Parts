package com.NinoCenov.CarSpareParts.converter;

import com.NinoCenov.CarSpareParts.dto.part.category.CategoryRequest;
import com.NinoCenov.CarSpareParts.dto.part.category.CategoryResponse;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public Category createCategory(CategoryRequest request){
        return Category.builder()
                .categoryName(request.getCategoryName())
                .categoryDescription(request.getCategoryDescription())
                .build();
    }

    public CategoryResponse toCategoryResponse(Category category){
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setCategoryName(category.getCategoryName());
        response.setCategoryDescription(category.getCategoryDescription());
        return response;
    }
}
