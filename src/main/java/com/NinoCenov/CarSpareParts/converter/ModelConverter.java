package com.NinoCenov.CarSpareParts.converter;
import com.NinoCenov.CarSpareParts.dto.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.repository.MakeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ModelConverter {

    private final MakeRepository makeRepository;

    public Model createModel(ModelRequest request){

        Make newMake = makeRepository.findByName(request.getMakeName());

        return Model.builder()
                .name(request.getModelName())
                .make(newMake)
                .build();
    }

    public ModelResponse toModelResponse(Model model){
        return ModelResponse.builder()
                .id(model.getId())
                .modelName(model.getName())
                .makeName(model.getMake().getName())
                .build();
    }
}
