package com.NinoCenov.CarSpareParts.repository;
import com.NinoCenov.CarSpareParts.dto.part.PartRequest;
import com.NinoCenov.CarSpareParts.entity.category.Category;
import com.NinoCenov.CarSpareParts.entity.part.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
  PartRequest findByName (String name);

  @Query("SELECT p FROM Part p JOIN p.models m WHERE p.category = :category AND m.name LIKE CONCAT('%',:modelName,'%')")
  List<Part> findByCategoryAndModelName(Category category, String modelName);

  List<Part> findByCategory (Category category);
}
