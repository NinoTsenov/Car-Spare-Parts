package com.NinoCenov.CarSpareParts.controller;
import com.NinoCenov.CarSpareParts.dto.part.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.part.model.ModelResponse;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.service.ModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/model")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService service;

    @PostMapping("/create")
    public ResponseEntity<ModelResponse> createModel(@Valid @RequestBody ModelRequest request){
        ModelResponse createdModel = service.createModel(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteModelById(@PathVariable Long id){
        service.deleteModelById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Model was successfully deleted");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ModelResponse>updateModel(@PathVariable Long id, @Valid @RequestBody ModelRequest request){
        ModelResponse updatedModel = service.updateModel(id, request);
        if(updatedModel!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedModel);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ModelResponse> getModelById(@PathVariable Long id){
        ModelResponse model = service.findModelById(id);
        if(model!=null){
           return ResponseEntity.status(HttpStatus.OK).body(model);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
