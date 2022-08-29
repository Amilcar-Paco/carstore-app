package com.pacocode.carstore.service;

import com.pacocode.carstore.model.Car;
import com.pacocode.carstore.repository.CarRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CarService {
    final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar (Car car) {
        car.setMotorCode(UUID.randomUUID().toString());
        return carRepository.save(car);
    }

    public List<Car> findAllCars () {
        return carRepository.findAll();
    }

    public Optional<Car> findCarByMotorCode (String motorCode) {
        return carRepository.findCarByMotorCode(motorCode);
    }

    public Car updateCar (Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(UUID id) {
        carRepository.deleteById(id);
    }

}
