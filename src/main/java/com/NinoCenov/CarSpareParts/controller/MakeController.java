package com.NinoCenov.CarSpareParts.controller;

import com.NinoCenov.CarSpareParts.dto.make.MakeRequest;
import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import com.NinoCenov.CarSpareParts.service.MakeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/make")
@RequiredArgsConstructor
public class MakeController {

    private final MakeService makeService;

    @PostMapping()
    public ResponseEntity<MakeResponse> createMake(@Valid @RequestBody MakeRequest request){
        MakeResponse createdMake = makeService.createMake(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdMake);
    }
    @PutMapping("{id}")
    public ResponseEntity<MakeResponse>updateMake(@PathVariable Long id, @Valid @RequestBody MakeRequest request){
        MakeResponse updatedMake = makeService.updateMake(id, request);
        if(updatedMake!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedMake);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMakeById(@PathVariable Long id){
        makeService.deleteMakeById(id);
        return ResponseEntity.status(HttpStatus.OK).body("This make was successfully deleted");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<MakeResponse> getMakeById(@PathVariable  Long id){
        MakeResponse foundMake = makeService.findMakeById(id);
        if(foundMake!=null){
            return ResponseEntity.status(HttpStatus.OK).body(foundMake);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @GetMapping()
    public ResponseEntity<List<MakeResponse>> getAllMakes() {
        return ResponseEntity.status(HttpStatus.OK).body(makeService.getAllMakes());
    }
}