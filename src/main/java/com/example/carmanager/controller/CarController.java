package com.example.carmanager.controller;

import com.example.carmanager.entity.Car;
import com.example.carmanager.exception.CarsException;
import com.example.carmanager.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car")
    public List<Car> getAllCars() {
        List<Car> cars = this.carService.getAllCars();
        System.out.println(cars.size());
        return cars;
    }

    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable int id) throws CarsException {
        return this.carService.getCarById(id);
    }

    @PostMapping("/car")
    public Car addCar(@RequestBody Car car) throws CarsException {
        return this.carService.createCar(car);
    }

    @PutMapping("/car/{id}")
    public Car updateCar(@PathVariable int id, @RequestBody Car car) throws CarsException {
        car.setCarId((long)id);
        return this.carService.updateCar(car);
    }
    @DeleteMapping("/car/{id}")
    public  boolean deleteCar(@PathVariable int id) throws CarsException {
        return this.carService.deleteCarById(id);
    }
}
