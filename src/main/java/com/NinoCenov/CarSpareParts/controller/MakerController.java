package com.NinoCenov.CarSpareParts.controller;
import com.NinoCenov.CarSpareParts.dto.part.MakerRequest;
import com.NinoCenov.CarSpareParts.dto.part.MakerResponse;
import com.NinoCenov.CarSpareParts.service.MakerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/maker")
@RequiredArgsConstructor
public class MakerController {

    private final MakerService service;

    @PostMapping("/create")
    public ResponseEntity<MakerResponse> createMaker(@Valid @RequestBody MakerRequest request){
        MakerResponse createdMaker = service.createMaker(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdMaker);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMakerById(@PathVariable Long id){
        service.deleteMakerById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Maker was successfully deleted");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MakerResponse>updateMaker(@PathVariable Long id, @Valid @RequestBody MakerRequest request){
        MakerResponse updatedMaker = service.updateMaker(id, request);
        if(updatedMaker!=null){
           return ResponseEntity.status(HttpStatus.OK).body(updatedMaker);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<MakerResponse>> getAllMakers(){
       return ResponseEntity.status(HttpStatus.OK).body(service.getAllMakers());
    }
}
