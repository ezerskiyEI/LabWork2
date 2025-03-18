package com.example.demo.service;


import com.example.demo.model.CarInfo;
import com.example.demo.repository.CarInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class CarInfoAnalyzerService {
    @Autowired
    private CarInfoRepository carInfoRepository;

    private static final Pattern VIN_PATTERN = Pattern.compile("[A-HJ-NPR-Z0-9]{17}");

    public Optional<CarInfo> findCarByVin(String vin) {
        return carInfoRepository.findByVin(vin);
    }

    public CarInfo saveCar(CarInfo carInfo) {
        return carInfoRepository.save(carInfo);
    }

    public void deleteCar(String vin) {
        carInfoRepository.deleteById(vin);
    }
}
