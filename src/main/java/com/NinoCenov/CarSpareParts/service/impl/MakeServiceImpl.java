package com.NinoCenov.CarSpareParts.service.impl;

import com.NinoCenov.CarSpareParts.converter.MakeConverter;
import com.NinoCenov.CarSpareParts.dto.make.MakeRequest;
import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.exeptions.MakeNotFoundException;
import com.NinoCenov.CarSpareParts.repository.MakeRepository;
import com.NinoCenov.CarSpareParts.service.MakeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MakeServiceImpl implements MakeService {

    private final MakeRepository repository;
    private final MakeConverter converter;

    @Override
    public MakeResponse createMake(MakeRequest request) {
        Make make = converter.createMake(request);
        Make savedMake = repository.save(make);
        return converter.toMakeResponse(savedMake);
    }

    @Override
    public void deleteMakeById(Long id) {
    repository.deleteById(id);
    }

    @Override
    public List<MakeResponse> getAllMakes() {
        List<Make> allMakes = repository.findAll();
        List<MakeResponse>extractedMakes=new ArrayList<>();
        for(Make make : allMakes){
           MakeResponse convertedMake = converter.toMakeResponse(make);
            extractedMakes.add(convertedMake);
        }
        return extractedMakes;
    }

    @Override
    public MakeResponse updateMake(Long id, MakeRequest request) {
        Make make = repository.findById(id).orElseThrow(
                ()-> new MakeNotFoundException("This make does not exist !"));
        make.setMake(request.getMake());
        Make updatedMake = repository.save(make);
        return converter.toMakeResponse(updatedMake);
    }

    @Override
    public MakeResponse findMakeById(Long id) {
        Make make = repository.findById(id).orElseThrow(
                ()-> new MakeNotFoundException("This make does not exist !"));
        return converter.toMakeResponse(make);
    }
}
