package com.NinoCenov.CarSpareParts.controller;

import com.NinoCenov.CarSpareParts.dto.part.CategoryRequest;
import com.NinoCenov.CarSpareParts.dto.part.CategoryResponse;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import com.NinoCenov.CarSpareParts.exeptions.CategoryNotFoundException;
import com.NinoCenov.CarSpareParts.repository.category.CategoryRepository;
import com.NinoCenov.CarSpareParts.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;
    private final CategoryRepository repository;

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request){
        CategoryResponse createdCategory = service.createCategory(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Category>getCategoryByName(@PathVariable String name){
        Category foundCategory = repository.findCategoryByCategoryName(name).orElseThrow(
                ()-> new CategoryNotFoundException("Category with such name was not found !"));

            return ResponseEntity.status(HttpStatus.FOUND).body(foundCategory);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id){
        service.deleteCategoryById(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Category was successfully deleted");
    }
}
