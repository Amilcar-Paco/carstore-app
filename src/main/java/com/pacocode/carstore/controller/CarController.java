package com.pacocode.carstore.controller;

import com.pacocode.carstore.dto.CarDto;
import com.pacocode.carstore.model.Car;
import com.pacocode.carstore.service.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars () {
        List<Car> cars = carService.findAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCarById (@PathVariable("id") UUID id) {
        Optional<Car> carOptional = carService.findCarById(id);
        return carOptional
                .<ResponseEntity<Object>>map
                        (car -> new ResponseEntity<>(car, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("Car: "+ id +" was not found.", HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Object> addCar (@RequestBody @Valid CarDto carDto) {
        var car = new Car();
        BeanUtils.copyProperties(carDto, car);
        Car newCar = carService.addCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCar (@PathVariable("id") UUID id,
                                             @RequestBody @Valid CarDto carDto) {
        Optional<Car> carOptional = carService.findCarById(id);
        if(!carOptional.isPresent()) {
            return new ResponseEntity<>("Car: "+ id +" was not found", HttpStatus.NOT_FOUND);
        }
        var car = new Car();
        BeanUtils.copyProperties(carDto, car);
        car.setId(carOptional.get().getId());
        car.setMotorCode(carOptional.get().getMotorCode());
        Car updateCar = carService.updateCar(car);

        return new ResponseEntity<>(updateCar, HttpStatus.OK);
    }

}
