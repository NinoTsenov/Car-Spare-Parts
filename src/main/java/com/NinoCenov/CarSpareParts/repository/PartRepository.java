//package com.NinoCenov.CarSpareParts.repository.part;
//
//import com.NinoCenov.CarSpareParts.entity.model.Model;
//import com.NinoCenov.CarSpareParts.entity.part.Part;
//import com.NinoCenov.CarSpareParts.entity.partcategory.PartCategory;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface PartRepository extends JpaRepository<Part, Long> {
//    @Query("SELECT r FROM Part r " +
//            "WHERE r.part.id = :partId " +
//            "AND (r.partCategory = :category) " +
//            "AND (r.model = :model)")
//    List<Part> getAllPartsByCategoryAndModels(@Param("partId") Long partId, @Param("category") PartCategory category,
//                                           @Param("model") Model model);
//
//
//}
