package com.NinoCenov.CarSpareParts.repository;
import com.NinoCenov.CarSpareParts.entity.make.Make;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findByMake (Make make);

    @Query("SELECT m FROM Model m WHERE m.make.name LIKE %:makeName%")
    List<Model> findByMakeName(String makeName);

    Model findByNameAndMakeName(String modelName, String makeName);

    Optional<Model> findByName(String modelName);


}
