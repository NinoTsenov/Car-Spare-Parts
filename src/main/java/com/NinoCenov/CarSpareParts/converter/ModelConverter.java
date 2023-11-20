package com.NinoCenov.CarSpareParts.converter;
import com.NinoCenov.CarSpareParts.dto.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.exceptions.MakeNotFoundException;
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

        Make make = makeRepository.findByMake(request.getMake().getMake()).orElseThrow(
                ()-> new MakeNotFoundException("This make is missing and will be created"));
        if (make==null){
            make = Make.builder().make(request.getMake().getMake()).build();
            makeRepository.save(make);
        }

        return Model.builder()
                .model(request.getModel())
                .make(make)
                .build();
    }

    public ModelResponse toModelResponse(Model model){
        ModelResponse response = new ModelResponse();
        response.setId(model.getId());
        response.setModel(model.getModel());
        response.setMake(model.getMake());
        return response;
    }
}
