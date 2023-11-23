package com.NinoCenov.CarSpareParts.repository;

import com.NinoCenov.CarSpareParts.entity.make.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeRepository extends JpaRepository<Make, Long> {
    Make findByName(String makeName);
}
