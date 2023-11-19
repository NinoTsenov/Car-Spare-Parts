package com.NinoCenov.CarSpareParts.repository;

import com.NinoCenov.CarSpareParts.entity.maker.Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends JpaRepository<Maker, Long> {
}
