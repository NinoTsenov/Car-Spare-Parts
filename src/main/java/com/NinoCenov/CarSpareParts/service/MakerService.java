package com.NinoCenov.CarSpareParts.service;

import com.NinoCenov.CarSpareParts.dto.part.MakerRequest;
import com.NinoCenov.CarSpareParts.dto.part.MakerResponse;

import java.util.List;


public interface MakerService {
    MakerResponse createMaker(MakerRequest request);
    void deleteMakerById(Long id);
    List<MakerResponse> getAllMakers();
    MakerResponse updateMaker(Long id,MakerRequest request);
    MakerResponse findMakerById(Long id);
}
