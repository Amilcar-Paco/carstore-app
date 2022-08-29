package com.pacocode.carstore.repository;

import com.pacocode.carstore.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    Optional<Car> findCarByMotorCode(String motorCode);
}
