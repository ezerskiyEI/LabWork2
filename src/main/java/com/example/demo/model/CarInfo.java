package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class CarInfo {
    @Id
    private String vin;  // VIN - первичный ключ

    private String make;  // Марка
    private String model; // Модель
    private int year;     // Год выпуска

    public CarInfo(String vin, String make, String model, int year) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
    }
}
