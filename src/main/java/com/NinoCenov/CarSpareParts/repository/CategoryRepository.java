package com.NinoCenov.CarSpareParts.repository;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
