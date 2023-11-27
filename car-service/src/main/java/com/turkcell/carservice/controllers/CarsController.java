package com.turkcell.carservice.controllers;

import com.turkcell.carservice.entities.Car;
import com.turkcell.carservice.entities.dtos.requests.CreateCarRequestDto;
import com.turkcell.carservice.entities.dtos.responses.CreatedCarResponseDto;
import com.turkcell.carservice.services.abstracts.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/cars")
@RestController
@RequiredArgsConstructor
public class CarsController {
    private final CarService carService;

    @PostMapping
    public void add(@RequestBody CreateCarRequestDto request) {
        carService.add(request);
    }

    @PutMapping("/inventoryCode")
    public void update(@RequestParam String inventoryCode, @RequestBody CreateCarRequestDto request) {
        carService.update(inventoryCode, request);
    }

    @DeleteMapping
    public void delete(String inventoryCode) {
        carService.delete(inventoryCode);
    }

    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/getByInventoryCode")
    public Car getByInventoryCode(@RequestParam String inventoryCode) {
        return carService.getByInventoryCode(inventoryCode);
    }

    @GetMapping("/getStateByInventoryCode")
    public Boolean getStateByInventoryCode(@RequestParam String inventoryCode) {
        return carService.getStateByInventoryCode(inventoryCode);
    }

    @GetMapping("/getDailyPriceByInventoryCode")
    public Double getDailyPriceByInventoryCode(@RequestParam String inventoryCode) {
        return carService.getDailyPriceByInventoryCode(inventoryCode);
    }

    @PostMapping("/updateState")
    public Boolean updateState(@RequestParam String inventoryCode, @RequestParam Boolean state) {
        return carService.updateState(inventoryCode, state);
    }


}
