package com.NinoCenov.CarSpareParts.repository;
import com.NinoCenov.CarSpareParts.entity.part.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
//    @Query("SELECT r FROM Part r " +
//            "WHERE r.part.id = :id " +
//            "AND (r.Category = :category) " +
//            "AND (r.model = :model)")
//    List<Part> getAllPartsByCategoryAndModels(@Param("id") Long id, @Param("category") Category category,
//                                           @Param("model") Model model);
//to do with stream !!!

}
