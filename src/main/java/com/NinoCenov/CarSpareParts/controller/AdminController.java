package com.NinoCenov.CarSpareParts.controller;

import com.NinoCenov.CarSpareParts.dto.make.MakeRequest;
import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import com.NinoCenov.CarSpareParts.dto.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
import com.NinoCenov.CarSpareParts.dto.model.ModelUpdateDTO;
import com.NinoCenov.CarSpareParts.dto.part.PartRequest;
import com.NinoCenov.CarSpareParts.dto.part.PartResponse;
import com.NinoCenov.CarSpareParts.service.MakeService;
import com.NinoCenov.CarSpareParts.service.ModelService;
import com.NinoCenov.CarSpareParts.service.PartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final MakeService makeService;
    private final ModelService modelService;
    private final PartService partService;

    @PostMapping("/createMake")
    public ResponseEntity<MakeResponse> createMake(@Valid @RequestBody MakeRequest request){
        MakeResponse createdMake = makeService.createMake(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdMake);
    }
    @PutMapping("/updateMake/{id}")
    public ResponseEntity<MakeResponse>updateMake(@PathVariable Long id, @Valid @RequestBody MakeRequest request){
        MakeResponse updatedMake = makeService.updateMake(id, request);
        if(updatedMake!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedMake);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/deleteMake/{id}")
    public ResponseEntity<String> deleteMakeById(@PathVariable Long id){
        makeService.deleteMakeById(id);
        return ResponseEntity.status(HttpStatus.OK).body("This make was successfully deleted");
    }

    @GetMapping("/getMakeById/{id}")
    public ResponseEntity<MakeResponse> getMakeById(@PathVariable  Long id){
        MakeResponse foundMake = makeService.findMakeById(id);
        if(foundMake!=null){
            return ResponseEntity.status(HttpStatus.OK).body(foundMake);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PostMapping("/createModel")
    public ResponseEntity<ModelResponse> createModel(@Valid @RequestBody ModelRequest request){
        ModelResponse createdModel = modelService.createModel(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdModel);
    }

    @DeleteMapping("/deleteModelById/{id}")
    public ResponseEntity<String> deleteModelById(@PathVariable Long id){
        modelService.deleteModelById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Model was successfully deleted");
    }


    @PutMapping("/updateModelById/{id}")
    public ResponseEntity<ModelResponse>updateModel(@PathVariable Long id, @Valid @RequestBody ModelUpdateDTO request){
        ModelResponse updatedModel = modelService.updateModel(id, request);
        if(updatedModel!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedModel);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @GetMapping("/findModelById/{id}")
    public ResponseEntity<ModelResponse> getModelById(@PathVariable Long id){
        ModelResponse model = modelService.findModelById(id);
        if(model!=null){
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PostMapping("/createPart")
    public ResponseEntity<PartResponse> createPart(@Valid @RequestBody PartRequest request){
        PartResponse createdPart = partService.createPart(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdPart);
    }

    @DeleteMapping("/deletePartById/{id}")
    public ResponseEntity<String> deletePartById(@PathVariable Long id){
        partService.deletePartById(id);
        return ResponseEntity.status(HttpStatus.OK).body("This part was successfully deleted");
    }

    @PutMapping("/updatePartById/{id}")
    public ResponseEntity<PartResponse>updatePart(@PathVariable Long id, @Valid @RequestBody PartRequest request){
        PartResponse updatedPart = partService.updatePart(id, request);
        if(updatedPart!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedPart);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
