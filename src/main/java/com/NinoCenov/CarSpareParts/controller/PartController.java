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
@RequestMapping("/api/v1/part")
@RequiredArgsConstructor
public class PartController {

    private final PartService partService;

    @PostMapping()
    public ResponseEntity<PartResponse> createPart(@Valid @RequestBody PartRequest request){
        PartResponse createdPart = partService.createPart(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdPart);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePartById(@PathVariable Long id){
        partService.deletePartById(id);
        return ResponseEntity.status(HttpStatus.OK).body("This part was successfully deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<PartResponse>updatePart(@PathVariable Long id, @Valid @RequestBody PartRequest request){
        PartResponse updatedPart = partService.updatePart(id, request);
        if(updatedPart!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedPart);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping()
    public ResponseEntity<List<PartResponse>> getAllParts(){
        return ResponseEntity.status(HttpStatus.OK).body(partService.getAllAvailableParts());
    }


    @GetMapping("/search/{id}")
    public ResponseEntity<PartResponse> getPartById(@PathVariable Long id){
        PartResponse foundPart = partService.getPartById(id);
        if(foundPart!=null){
            return ResponseEntity.status(HttpStatus.OK).body(foundPart);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @GetMapping("/search/{categoryId}/{model}")
    public ResponseEntity<List<PartResponse>> getPartsByCategoryAndModel(@PathVariable Long categoryId,
                                                                         @RequestParam(value = "model", required = false) String model){
        List<PartResponse> foundPartsList = partService.getAllPartsByCategoryAndModel(categoryId, model);
        if(foundPartsList!=null && !foundPartsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(foundPartsList);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @GetMapping("/search/{name}")
    public ResponseEntity<List<PartResponse>> getPartsByName(
            @PathVariable String name){
        List<PartResponse> foundPartsList = partService.getAllPartsInAllCategoriesByPartName(name);
        if(foundPartsList!=null && !foundPartsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(foundPartsList);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
