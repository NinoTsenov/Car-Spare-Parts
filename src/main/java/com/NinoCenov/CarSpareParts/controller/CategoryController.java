package com.NinoCenov.CarSpareParts.controller;
import com.NinoCenov.CarSpareParts.dto.category.CategoryRequest;
import com.NinoCenov.CarSpareParts.dto.category.CategoryResponse;
import com.NinoCenov.CarSpareParts.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;


    @PostMapping()
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request){

        return  ResponseEntity.status(HttpStatus.CREATED).body(service.createCategory(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id){
        service.deleteCategoryById(id);
       return ResponseEntity.status(HttpStatus.OK).body("Category was successfully deleted");
    }
}
