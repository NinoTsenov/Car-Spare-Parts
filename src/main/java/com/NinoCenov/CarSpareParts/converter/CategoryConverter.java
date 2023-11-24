package com.NinoCenov.CarSpareParts.converter;
import com.NinoCenov.CarSpareParts.dto.category.CategoryRequest;
import com.NinoCenov.CarSpareParts.dto.category.CategoryResponse;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryConverter {



    public Category createCategory(CategoryRequest request){
        return Category.builder()
                .name(request.getCategoryName())
                .categoryDescription(request.getCategoryDescription())
                .build();
    }

    public CategoryResponse toCategoryResponse(Category category){

        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setCategoryName(category.getName());
        response.setCategoryDescription(category.getCategoryDescription());
        return response;
    }
}
