package com.example.carmanager.service;

import com.example.carmanager.entity.Car;
import com.example.carmanager.repository.CarRepository;
import com.example.carmanager.exception.CarsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    final private CarRepository carRepository;
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Get all cars
     * @return List<Car>
     */
    public List<Car> getAllCars() {
        List<Car> cars = this.carRepository.findAll();
        cars.forEach(System.out::println);
        return cars;
    }

    /**
     * Finds Cars by Id
     * @param id Car Id
     * @return Car
     */
    public Car getCarById(int id) throws CarsException {
        return this.carRepository.findById((long) id).orElseThrow(() -> new CarsException(
                CarsException.CARS_NOT_FOUND));
    }

    /**
     *  Create Car
     * @param car New Car
     * @return Car
     */
    public Car createCar(Car car) {
        return this.carRepository.save(car);
    }

    /**
     * Delete the specified Car
     * @param id car id
     */
    public boolean deleteCarById(int id) {
        this.carRepository.deleteById((long) id);
        Car car = this.carRepository.findById((long) id).orElse(null);
        return car == null;
    }

    /**
     * Update the car
     * @param car carId
     * @return Updated Car
     */
    public Car updateCar(Car updatedCar) throws CarsException {
        Car car = this.carRepository.findById((long) updatedCar.getCarId()).orElseThrow(() ->  new CarsException(CarsException.CARS_NOT_FOUND));

//        car.setCarId(updatedCar.getCarId());
        car.setImage(updatedCar.getImage());
        car.setSeating(updatedCar.getSeating());
        car.setModelName(updatedCar.getModelName());
        return this.carRepository.saveAndFlush(car);
    }

}
