package com.NinoCenov.CarSpareParts.converter;

import com.NinoCenov.CarSpareParts.dto.part.MakerRequest;
import com.NinoCenov.CarSpareParts.dto.part.MakerResponse;
import com.NinoCenov.CarSpareParts.entity.maker.Maker;
import org.springframework.stereotype.Component;

@Component
public class MakerConverter {
    public Maker createMaker (MakerRequest request){
        return Maker.builder().makerName(request.getMakerName()).build();
    }

    public MakerResponse toMakerResponse(Maker maker){
     MakerResponse response = new MakerResponse();
     response.setId(maker.getId());
     response.setMakerName(maker.getMakerName());
     return response;
    }
}
