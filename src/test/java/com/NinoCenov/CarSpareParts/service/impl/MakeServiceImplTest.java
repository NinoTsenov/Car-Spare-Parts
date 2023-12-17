package com.NinoCenov.CarSpareParts.service.impl;
import com.NinoCenov.CarSpareParts.converter.MakeConverter;
import com.NinoCenov.CarSpareParts.dto.make.MakeRequest;
import com.NinoCenov.CarSpareParts.dto.make.MakeResponse;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.repository.MakeRepository;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MakeServiceImplTest {

    @InjectMocks
    private MakeServiceImpl makeService;

    @Mock
    private MakeRepository makeRepository;

    @Mock
    private MakeConverter makeConverter;


    private AutoCloseable autoCloseable;

    @BeforeEach
    public void setup() {

       autoCloseable = MockitoAnnotations.openMocks(this);
       makeService = new MakeServiceImpl(makeRepository,makeConverter);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void createMake() {

     //given
        Make makeToCreate = Make.builder().id(1L).name("Mercedes").build();
     //when
        when(makeConverter.createMake(any())).thenReturn(makeToCreate);
        when(makeRepository.save(makeToCreate)).thenReturn(makeToCreate);
        when(makeConverter.toMakeResponse(makeToCreate)).thenReturn(new MakeResponse());

        makeService.createMake(any());
      //then
        verify(makeConverter,times(1)).createMake(any());
        verify(makeRepository,times(1)).save(makeToCreate);
        verify(makeConverter,times(1)).toMakeResponse(makeToCreate);
    }

    @Test
    void deleteMakeById() {
        Long makeId = 1L;
        makeService.deleteMakeById(makeId);
        verify(makeRepository,times(1)).deleteById(makeId);
    }

    @Test
    void getAllMakes() {
        List<Make> foundAllMakes = new ArrayList<>();

        Make make1 = new Make (1L,"Mercedes",null);
        Make make2 = new Make (2L,"BMW",null);
        Make make3 = new Make (3L,"Ford",null);
        foundAllMakes.add(make1);
        foundAllMakes.add(make2);
        foundAllMakes.add(make3);
        when(makeRepository.findAll()).thenReturn(foundAllMakes);
        List<MakeResponse> result = makeService.getAllMakes();
        verify(makeRepository,times(1)).findAll();
        assertEquals(foundAllMakes.size(), result.size());
    }

    @Test
    void updateMake() {

        MakeRequest upDateMake = new MakeRequest("BMW");
        Make existingMake = Make.builder().id(1L).name("Mercedes").build();

        when(makeRepository.findById(1L)).thenReturn(Optional.of(existingMake));
        when(makeRepository.save(existingMake)).thenReturn(existingMake);

        MakeResponse expectedResponse = new MakeResponse();
        when(makeConverter.toMakeResponse(existingMake)).thenReturn(expectedResponse);

        MakeResponse response = makeService.updateMake(1L,upDateMake);

        assertNotNull(response);
        verify(makeRepository,times(1)).findById(1L);
        verify(makeRepository,times(1)).save(existingMake);
        verify(makeConverter,times(1)).toMakeResponse(existingMake);
        assertEquals(expectedResponse,response);
    }

    @Test
    void findMakeByIdShouldPass() {

        Long makeId = 1L;
        Make make1 = Make.builder().id(makeId).name("Mercedes").build();
        when(makeRepository.findById(makeId)).thenReturn(Optional.of(make1));

        Optional<Make> result = makeService.getMakeById(makeId);

        assertTrue(result.isPresent());
        assertEquals(makeId,result.get().getId());
        assertEquals("Mercedes",result.get().getName());

    }
}