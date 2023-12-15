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
@RequestMapping("/api/v1/makes")
@RequiredArgsConstructor
public class MakeController {

    private final MakeService makeService;

    @PostMapping()
    public ResponseEntity<MakeResponse> createMake(@Valid @RequestBody MakeRequest request){

        return  ResponseEntity.status(HttpStatus.CREATED).body(makeService.createMake(request));
    }
    @PutMapping("{id}")
    public ResponseEntity<MakeResponse>updateMake(@PathVariable Long id, @Valid @RequestBody MakeRequest request){

            return ResponseEntity.status(HttpStatus.OK).body(makeService.updateMake(id,request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMakeById(@PathVariable Long id){
        makeService.deleteMakeById(id);
        return ResponseEntity.status(HttpStatus.OK).body("This make was successfully deleted");
    }

    @GetMapping("{id}")
    public ResponseEntity<MakeResponse> getMakeById(@PathVariable  Long id){
            return ResponseEntity.status(HttpStatus.OK).body(makeService.findMakeById(id));
    }


    @GetMapping()
    public ResponseEntity<List<MakeResponse>> getAllMakes() {
        return ResponseEntity.status(HttpStatus.OK).body(makeService.getAllMakes());
    }
}
