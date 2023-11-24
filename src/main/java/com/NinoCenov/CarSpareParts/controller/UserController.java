package com.NinoCenov.CarSpareParts.controller;
import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
import com.NinoCenov.CarSpareParts.dto.part.PartResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.service.MakeService;
import com.NinoCenov.CarSpareParts.service.ModelService;
import com.NinoCenov.CarSpareParts.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor

public class UserController {


    private final MakeService makeService;
    private final ModelService modelService;
    private final PartService partService;


    @GetMapping("/getAllMakes")
    public ResponseEntity<List<MakeResponse>> getAllMakes() {
        return ResponseEntity.status(HttpStatus.OK).body(makeService.getAllMakes());
    }

    @GetMapping("/findModelsByMake/{make}")
    public ResponseEntity<List<ModelResponse>> getModelsByMake(@PathVariable Make make){
        List<ModelResponse> allModels = modelService.findAllModelsByMake(make);
        if(allModels!=null){
            return ResponseEntity.status(HttpStatus.OK).body(allModels);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/getAllParts")
    public ResponseEntity<List<PartResponse>> getAllParts(){
        return ResponseEntity.status(HttpStatus.OK).body(partService.getAllAvailableParts());
    }

    @GetMapping("/partById/{id}")
    public ResponseEntity<PartResponse> getPartById(@PathVariable Long id){
        PartResponse foundPart = partService.getPartById(id);
        if(foundPart!=null){
            return ResponseEntity.status(HttpStatus.OK).body(foundPart);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/getPartByCategoryAndModel/{categoryId}/{model}")
    public ResponseEntity<List<PartResponse>> getPartsByCategoryAndModel(@PathVariable Long categoryId,
                                                                         @RequestParam(value = "model", required = false) String model){
        List<PartResponse> foundPartsList = partService.getAllPartsByCategoryAndModel(categoryId, model);
        if(foundPartsList!=null && !foundPartsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(foundPartsList);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/getPartByPartName/{name}")
    public ResponseEntity<List<PartResponse>> getPartsByName(
            @PathVariable String name){
        List<PartResponse> foundPartsList = partService.getAllPartsInAllCategoriesByPartName(name);
        if(foundPartsList!=null && !foundPartsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(foundPartsList);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
