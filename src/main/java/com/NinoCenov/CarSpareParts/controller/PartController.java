package com.NinoCenov.CarSpareParts.controller;
import com.NinoCenov.CarSpareParts.dto.part.PartRequest;
import com.NinoCenov.CarSpareParts.dto.part.PartResponse;
import com.NinoCenov.CarSpareParts.service.PartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parts")
@RequiredArgsConstructor
public class PartController {

    private final PartService partService;

    @PostMapping()
    public ResponseEntity<PartResponse> createPart(@Valid @RequestBody PartRequest request){

        return  ResponseEntity.status(HttpStatus.CREATED).body(partService.createPart(request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePartById(@PathVariable Long id){
        partService.deletePartById(id);
        return ResponseEntity.status(HttpStatus.OK).body("This part was successfully deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<PartResponse>updatePart(@PathVariable Long id, @Valid @RequestBody PartRequest request){

            return ResponseEntity.status(HttpStatus.OK).body(partService.updatePart(id,request));
    }

    @GetMapping()
    public ResponseEntity<List<PartResponse>> getAllParts(){
        return ResponseEntity.status(HttpStatus.OK).body(partService.getAllAvailableParts());
    }

    @GetMapping("{id}")
    public ResponseEntity<PartResponse> getPartById(@PathVariable Long id){
            return ResponseEntity.status(HttpStatus.OK).body(partService.getPartById(id));
    }

    @GetMapping("/search/{categoryId}")
    public ResponseEntity<List<PartResponse>> getPartsByCategoryAndModel(@PathVariable Long categoryId,
                                                     @RequestParam(value = "model",required = false) String model) {
        if (model!=null&& !model.isEmpty())

        return ResponseEntity.status(HttpStatus.OK).body(partService.getAllPartsByCategoryAndModel(categoryId,model));

        else
            return ResponseEntity.status(HttpStatus.OK).body(partService.getAllPartsByCategory(categoryId));
    }
    @GetMapping("{name}")
    public ResponseEntity<List<PartResponse>> getPartsByName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(partService.getAllPartsInAllCategoriesByPartName(name));
    }
}
