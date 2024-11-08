package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.CompassModel;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CompassController {
    private final CompassModel compassModel = CompassModel.getInstance();

    @PostMapping(value = "/setDirections", consumes = "application/json")
    public void setDirections(@RequestBody Map<String, String> directions) {
        directions.forEach(compassModel::setDirection);
    }

    @GetMapping(value = "/getDirection", produces = "application/json")
    public Map<String, String> getDirection(@RequestBody Map<String, Integer> request) {
        int degree = request.get("Degree");
        String direction = compassModel.getDirection(degree);
        Map<String, String> response = new HashMap<>();
        response.put("Side", direction);
        return response;
    }
}
