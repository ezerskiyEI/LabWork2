package com.example.demo.Controller;

import com.example.demo.model.CarInfo;
import com.example.demo.service.CarInfoAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarInfoController {

    @Autowired
    private CarInfoAnalyzerService analyzerService;

    // Поиск машины по VIN
    @GetMapping("/find")
    public ResponseEntity<CarInfo> getCarByVin(@RequestParam String vin) {
        Optional<CarInfo> carInfo = analyzerService.findCarByVin(vin);
        return carInfo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Добавление машины в базу данных
    @PostMapping("/add")
    public ResponseEntity<CarInfo> addCar(@RequestBody CarInfo car) {
        CarInfo savedCar = analyzerService.saveCar(car);
        return ResponseEntity.ok(savedCar);
    }

    // Удаление машины по VIN
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCar(@RequestParam String vin) {
        analyzerService.deleteCar(vin);
        return ResponseEntity.ok("Car deleted successfully");
    }
}
