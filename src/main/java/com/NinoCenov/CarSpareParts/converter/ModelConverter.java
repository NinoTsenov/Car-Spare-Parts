package com.NinoCenov.CarSpareParts.converter;
import com.NinoCenov.CarSpareParts.dto.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.exceptions.MakeNotFoundException;
import com.NinoCenov.CarSpareParts.exceptions.ModelNotFoundException;
import com.NinoCenov.CarSpareParts.repository.MakeRepository;
import com.NinoCenov.CarSpareParts.service.MakeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ModelConverter {

    private final MakeRepository makeRepository;
    private final MakeService makeService;

    public Model createModel(ModelRequest request){
        Make newMake = makeRepository.findByMakeName(request.getMake().getMakeName()).orElseGet(() -> {
            Make make = Make.builder().makeName(request.getMake().getMakeName()).build();
            makeRepository.save(make);
            return make;
        });

        return Model.builder()
                .model(request.getModel())
                .make(newMake)
                .build();
    }

    public ModelResponse toModelResponse(Model model){
        Make newMake = makeRepository.findByMakeName(model.getMake().getMakeName()).orElseGet(() -> {
            Make make = Make.builder().makeName(model.getMake().getMakeName()).build();
            makeRepository.save(make);
            return make;
        });
        ModelResponse response = new ModelResponse();
        response.setId(model.getId());
        response.setModel(model.getModel());
        response.setMakeName(model.getMake().getMakeName());
        return response;
    }
}
