package com.NinoCenov.CarSpareParts.repository.model;

import com.NinoCenov.CarSpareParts.entity.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
}
