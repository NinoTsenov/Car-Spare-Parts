package com.NinoCenov.CarSpareParts.controller;

import com.NinoCenov.CarSpareParts.dto.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
import com.NinoCenov.CarSpareParts.dto.model.ModelUpdateDTO;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.service.ModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/models")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @PostMapping("/admin")
    public ResponseEntity<ModelResponse> createModel(@Valid @RequestBody ModelRequest request) {

        return  ResponseEntity.status(HttpStatus.CREATED).body(modelService.createModel(request));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteModelById(@PathVariable Long id) {
        modelService.deleteModelById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Model was successfully deleted");
    }


    @PutMapping("{id}")
    public ResponseEntity<ModelResponse>updateModel(@PathVariable Long id, @Valid @RequestBody ModelUpdateDTO request) {
            return ResponseEntity.status(HttpStatus.OK).body(modelService.updateModel(id,request));
    }


    @GetMapping("{id}")
    public ResponseEntity<ModelResponse> getModelById(@PathVariable Long id) {
            return ResponseEntity.status(HttpStatus.OK).body(modelService.findModelById(id));
    }


    @GetMapping("{make}")
    public ResponseEntity<List<ModelResponse>> getModelsByMake(@RequestParam Make make) {
            return ResponseEntity.status(HttpStatus.OK).body(modelService.findAllModelsByMake(make));
    }
}
