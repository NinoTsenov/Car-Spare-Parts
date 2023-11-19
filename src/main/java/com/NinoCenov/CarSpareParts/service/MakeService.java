package com.NinoCenov.CarSpareParts.service;

import com.NinoCenov.CarSpareParts.dto.part.make.MakeRequest;
import com.NinoCenov.CarSpareParts.dto.part.make.MakeResponse;

import java.util.List;


public interface MakeService {
    MakeResponse createMake(MakeRequest request);
    void deleteMakeById(Long id);
    List<MakeResponse> getAllMakes();
    MakeResponse updateMake(Long id, MakeRequest request);
    MakeResponse findMakeById(Long id);
}
