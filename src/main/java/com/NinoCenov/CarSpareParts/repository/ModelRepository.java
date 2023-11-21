package com.NinoCenov.CarSpareParts.repository;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import com.NinoCenov.CarSpareParts.entity.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    Optional<Model> findByModel(String model);
}
