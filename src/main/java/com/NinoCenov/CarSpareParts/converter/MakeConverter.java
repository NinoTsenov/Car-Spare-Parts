package com.NinoCenov.CarSpareParts.converter;

import com.NinoCenov.CarSpareParts.dto.make.MakeRequest;
import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import org.springframework.stereotype.Component;

@Component
public class MakeConverter {
    public Make createMake (MakeRequest request){
        return Make.builder()
                .make(request.getMake())
                .build();
    }

    public MakeResponse toMakeResponse(Make make){
     MakeResponse response = new MakeResponse();
     response.setId(make.getId());
     response.setMake(make.getMake());
     response.setModel(make.getModels()); //have to check !!!
     return response;
    }
}
