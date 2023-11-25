package com.NinoCenov.CarSpareParts.service.impl;

import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.repository.MakeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class MakeServiceImplTest {

    @InjectMocks
    private MakeServiceImpl makeService;

    @Mock
    private MakeRepository makeRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateMake() {

        Make make = new Make();
        make.setId(1L);
        make.setName("Porsche");
        Assertions.assertFalse(make.getName().isEmpty());
        Assertions.assertEquals(1L, make.getId());

    }

    @Test
    public void shouldDeleteMake(){
        Long makeId = 1L;
        makeService.deleteMakeById(makeId);
        verify(makeRepository, times(1)).deleteById(makeId);

    }
}