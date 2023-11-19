package com.NinoCenov.CarSpareParts.service.impl;

import com.NinoCenov.CarSpareParts.converter.MakerConverter;
import com.NinoCenov.CarSpareParts.dto.part.MakerRequest;
import com.NinoCenov.CarSpareParts.dto.part.MakerResponse;
import com.NinoCenov.CarSpareParts.entity.maker.Maker;
import com.NinoCenov.CarSpareParts.exeptions.MakerNotFoundException;
import com.NinoCenov.CarSpareParts.repository.MakerRepository;
import com.NinoCenov.CarSpareParts.service.MakerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MakerServiceImpl implements MakerService {

    private final MakerRepository repository;
    private final MakerConverter converter;

    @Override
    public MakerResponse createMaker(MakerRequest request) {
        Maker maker = converter.createMaker(request);
        Maker savedMaker = repository.save(maker);
        return converter.toMakerResponse(savedMaker);
    }

    @Override
    public void deleteMakerById(Long id) {
    repository.deleteById(id);
    }

    @Override
    public List<MakerResponse> getAllMakers() {
        List<Maker> allMakers = repository.findAll();
        List<MakerResponse>extractedMakers=new ArrayList<>();
        for(Maker maker:allMakers){
           MakerResponse convertedMaker = converter.toMakerResponse(maker);
            extractedMakers.add(convertedMaker);
        }
        return extractedMakers;
    }

    @Override
    public MakerResponse updateMaker(Long id, MakerRequest request) {
        Maker maker = repository.findById(id).orElseThrow(
                ()-> new MakerNotFoundException("This maker does not exist !"));
        maker.setMakerName(request.getMakerName());
        Maker updatedMaker = repository.save(maker);

        return converter.toMakerResponse(updatedMaker);
    }

    @Override
    public MakerResponse findMakerById(Long id) {
        Maker maker = repository.findById(id).orElseThrow(
                ()-> new MakerNotFoundException("This maker does not exist !"));
        return converter.toMakerResponse(maker);
    }
}
