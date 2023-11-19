package com.NinoCenov.CarSpareParts.controller;
import com.NinoCenov.CarSpareParts.dto.part.CategoryRequest;
import com.NinoCenov.CarSpareParts.dto.part.CategoryResponse;
import com.NinoCenov.CarSpareParts.repository.CategoryRepository;
import com.NinoCenov.CarSpareParts.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;


    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request){
        CategoryResponse createdCategory = service.createCategory(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id){
        service.deleteCategoryById(id);
       return ResponseEntity.status(HttpStatus.OK).body("Category was successfully deleted");
    }
}
