package com.NinoCenov.CarSpareParts.repository;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
class MakeRepositoryTest {

    @Autowired
    private MakeRepository makeRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        makeRepository.deleteAll();
    }

    @Test
    void findByName() {
        //given
        Make make = Make.builder().id(1L).name("Mercedes").build();

        //when
        makeRepository.save(make);
        Make foundMake = makeRepository.findByName("Mercedes");

        //then
        assertThat(foundMake).isNotNull();
        assertThat(foundMake.getId().equals(1L));

    }

    @Test
    void findByNameShouldFail() {
        //given
        Make make = Make.builder().id(1L).name("BMW").build();

        //when
        makeRepository.save(make);
        Make foundMake = makeRepository.findByName("Mercedes");

        //then
    //    assertThat(foundMake).isNotNull(); -> in this case will fail
        assertThat(foundMake).isNull();
    }
}