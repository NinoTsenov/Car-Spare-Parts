package com.NinoCenov.CarSpareParts.converter;
import com.NinoCenov.CarSpareParts.dto.make.MakeRequest;
import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
public class MakeConverter {

    private final ModelRepository modelRepository;

    public Make createMake(MakeRequest request) {
        return Make.builder()
                .make(request.getMake())
                .build();
    }

    public MakeResponse toMakeResponse(Make make) {
        MakeResponse response = new MakeResponse();
        response.setId(make.getId());
        response.setMake(make.getMake());
        return response;
    }
}
