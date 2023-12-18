package com.NinoCenov.CarSpareParts.repository;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ModelRepositoryTest {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private MakeRepository makeRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        modelRepository.deleteAll();
        makeRepository.deleteAll();
    }

    @Test
    void findByMake() {

        Make make = new Make();
        make.setName("Pontiac");
        makeRepository.save(make);


        Model model = new Model();
        model.setName("GTO");
        model.setMake(make);
        modelRepository.save(model);

        List<Model> models = modelRepository.findByMake(make);
        assertEquals(1, models.size());
        assertEquals("GTO", models.get(0).getName());
    }


    @Test
    void findByNameAndMakeName() {

        Make make = new Make();
        make.setName("Ford");
        makeRepository.save(make);

        Model model = new Model();
        model.setName("Fusion");
        model.setMake(make);
        modelRepository.save(model);

        Model foundModel = modelRepository.findByNameAndMakeName("Fusion", "Ford");
        assertNotNull(foundModel);
        assertEquals("Fusion", foundModel.getName());

    }
}