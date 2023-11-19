package com.NinoCenov.CarSpareParts.converter;
import com.NinoCenov.CarSpareParts.dto.part.PartRequest;
import com.NinoCenov.CarSpareParts.dto.part.PartResponse;
import com.NinoCenov.CarSpareParts.entity.part.Part;
import org.springframework.stereotype.Component;

@Component
public class PartConverter {

    public Part createPart (PartRequest request){
        return Part.builder()
                .partName(request.getPartName())
                .partDescription(request.getPartDescription())
                .price(request.getPrice())
            //    .category(request.getCategory())  same as make
                .setOfPartsAndModels(request.getSetOfPartsAndModels())
                .build();
    }


    public PartResponse toPartResponse(Part part) {
        PartResponse response = new PartResponse();
        response.setId(part.getId());
        response.setPartName(part.getPartName());
        response.setPartDescription(part.getPartDescription());
        response.setPrice(part.getPrice());
        response.setCategory(part.getCategory());
       // response.set  new arraylist + for loop
        return response;
    }
}
