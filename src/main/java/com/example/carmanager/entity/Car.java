package com.example.carmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Car {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long carId;
    String modelName;
    int seating;
    String image;

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", modelName='" + modelName + '\'' +
                ", seating=" + seating +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return seating == car.seating && Objects.equals(carId, car.carId) && Objects.equals(modelName, car.modelName) && Objects.equals(image, car.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, modelName, seating, image);
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
