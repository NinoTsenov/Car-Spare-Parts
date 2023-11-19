package com.NinoCenov.CarSpareParts.repository;

import com.NinoCenov.CarSpareParts.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
