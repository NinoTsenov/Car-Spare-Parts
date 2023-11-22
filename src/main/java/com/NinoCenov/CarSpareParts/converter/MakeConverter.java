package com.NinoCenov.CarSpareParts.converter;
import com.NinoCenov.CarSpareParts.dto.make.MakeRequest;
import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
public class MakeConverter {



    public Make createMake(MakeRequest request) {
        return Make.builder()
                .makeName(request.getMakeName())
                .build();
    }

    public MakeResponse toMakeResponse(Make make) {
        MakeResponse response = new MakeResponse();
        response.setId(make.getId());
        response.setMakeName(make.getMakeName());
        return response;
    }
}
