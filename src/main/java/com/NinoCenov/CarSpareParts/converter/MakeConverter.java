package com.NinoCenov.CarSpareParts.converter;
import com.NinoCenov.CarSpareParts.dto.make.MakeRequest;
import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class MakeConverter {

    private final ModelRepository modelRepository;

    public Make createMake(MakeRequest request) {
        return Make.builder()
                .name(request.getMakeName())
                .build();
    }

    public MakeResponse toMakeResponse(Make make) {

        List<Model> modelList = modelRepository.findByMake(make);
        List<String> modelNames = modelList.stream()
                .map(Model::getName)
                .collect(Collectors.toList());

        MakeResponse response = new MakeResponse();
        response.setId(make.getId());
        response.setMakeName(make.getName());
        response.setModelNames(modelNames);

        return response;
    }
}
