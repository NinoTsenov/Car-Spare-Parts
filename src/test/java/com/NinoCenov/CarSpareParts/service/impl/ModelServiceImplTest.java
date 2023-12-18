package com.NinoCenov.CarSpareParts.service.impl;
import com.NinoCenov.CarSpareParts.converter.ModelConverter;
import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import com.NinoCenov.CarSpareParts.dto.model.ModelRequest;
import com.NinoCenov.CarSpareParts.dto.model.ModelResponse;
import com.NinoCenov.CarSpareParts.dto.model.ModelUpdateDTO;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import com.NinoCenov.CarSpareParts.repository.MakeRepository;
import com.NinoCenov.CarSpareParts.repository.ModelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ModelServiceImplTest {

    @InjectMocks
    private ModelServiceImpl modelService;

    @Mock
    private ModelRepository modelRepository;

    @Mock
    private ModelConverter modelConverter;

    @Mock
    private MakeRepository makeRepository;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {


        autoCloseable = MockitoAnnotations.openMocks(this);
        modelService = new ModelServiceImpl(modelRepository,modelConverter,makeRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAllModelsByMake() {
        Make make = new Make();
        when(modelRepository.findByMake(make)).thenReturn(Arrays.asList(new Model()));

        List<ModelResponse> result = modelService.findAllModelsByMake(make);

        verify(modelRepository, times(1)).findByMake(make);
        verify(modelConverter, times(1)).toModelResponse(any(Model.class));
        assertEquals(1, result.size());
    }

    @Test
    void createModel() {
        ModelRequest request = new ModelRequest();
        Model model = new Model();
        ModelResponse response = new ModelResponse();

        when(modelConverter.createModel(request)).thenReturn(model);
        when(modelRepository.save(model)).thenReturn(model);
        when(modelConverter.toModelResponse(model)).thenReturn(response);

        ModelResponse result = modelService.createModel(request);

        verify(modelRepository, times(1)).save(model);
        verify(modelConverter, times(1)).toModelResponse(model);
        assertEquals(response, result);
    }

    @Test
    void deleteModelById() {
        Long id = 1L;

        modelService.deleteModelById(id);

        verify(modelRepository, times(1)).deleteById(id);
    }

    @Test
    void updateModel() {
        Long id = 1L;
        MakeResponse makeResponse = new MakeResponse();
        ModelUpdateDTO request = new ModelUpdateDTO("Alabala", makeResponse);
        Model model = new Model();
        Make make = new Make();
        model.setMake(make);
        ModelResponse response = new ModelResponse();

        when(modelRepository.findById(id)).thenReturn(Optional.of(model));
        when(makeRepository.save(make)).thenReturn(make);
        when(modelRepository.save(model)).thenReturn(model);
        when(modelConverter.toModelResponse(model)).thenReturn(response);

        ModelResponse result = modelService.updateModel(id, request);

        verify(modelRepository, times(1)).findById(id);
        verify(makeRepository, times(1)).save(make);
        verify(modelRepository, times(1)).save(model);
        verify(modelConverter, times(1)).toModelResponse(model);
        assertEquals(response, result);
    }

    @Test
    void findModelById() {
        Long id = 1L;
        Model model = new Model();
        ModelResponse response = new ModelResponse();

        when(modelRepository.findById(id)).thenReturn(Optional.of(model));
        when(modelConverter.toModelResponse(model)).thenReturn(response);

        ModelResponse result = modelService.findModelById(id);

        verify(modelRepository, times(1)).findById(id);
        verify(modelConverter, times(1)).toModelResponse(model);
        assertEquals(response, result);
    }

    @Test
    void findAll() {
        List<Model> models = Arrays.asList(new Model());
        List<ModelResponse> responses = Arrays.asList(new ModelResponse());

        when(modelRepository.findAll()).thenReturn(models);
        when(modelConverter.toModelResponse(any(Model.class))).thenReturn(responses.get(0));

        List<ModelResponse> result = modelService.findAll();

        verify(modelRepository, times(1)).findAll();
        verify(modelConverter, times(1)).toModelResponse(any(Model.class));
        assertEquals(responses, result);
    }
}