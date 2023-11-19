package com.NinoCenov.CarSpareParts.service.impl;

import com.NinoCenov.CarSpareParts.converter.PartConverter;
import com.NinoCenov.CarSpareParts.dto.part.PartRequest;
import com.NinoCenov.CarSpareParts.dto.part.PartResponse;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.entity.part.Part;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import com.NinoCenov.CarSpareParts.exeptions.PartNotFoundException;
import com.NinoCenov.CarSpareParts.repository.PartRepository;
import com.NinoCenov.CarSpareParts.service.PartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository repository;
    private final PartConverter converter;

    @Override
    public PartResponse createPart(PartRequest request) {


        return null;
    }

    @Override
    public PartResponse updatePart(Long id, PartRequest request) {


        return null;
    }

    @Override
    public void deletePartById(Long id) {
    repository.deleteById(id);
    }

    @Override
    public List<PartResponse> getAllAvailableParts() {
        List<Part> allParts = repository.findAll();
        return allParts.stream().map(converter::toPartResponse).toList();
    }

    @Override
    public PartResponse getPartById(Long id) {
        Part part = repository.findById(id).orElseThrow(()-> new PartNotFoundException("Part not found"));
        return converter.toPartResponse(part);
    }

    @Override
    public List<PartResponse> getAllPartsByCategoryAndModels(Long id, Category category, Model model) {
//        List<Part> allParts = repository.findAll();
//        List<Part> availableParts = new ArrayList<>();
//
//        for(Part part : allParts){
//            Long partId = part.getId();
//            List<Part> parts = repository.getAllPartsByCategoryAndModels(partId,category,model);
//            if(parts.isEmpty()){
//                availableParts.add(part);
//            }
//        }
//        List<PartResponse> listOfParts=availableParts.stream().map(converter::toPartResponse).toList();
//
//        return listOfParts;
        return null;
    }

    @Override
    public List<PartResponse> getAllPartsInAllCategoriesByName(String partName) {
        return null;
    }
}
