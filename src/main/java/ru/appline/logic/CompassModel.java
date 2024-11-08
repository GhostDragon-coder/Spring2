package ru.appline.logic;

import java.util.HashMap;
import java.util.Map;

public class CompassModel {
    private static final CompassModel instance = new CompassModel();
    private final Map<String, String> directions = new HashMap<>();

    private CompassModel() {}

    public static CompassModel getInstance() {
        return instance;
    }

    public void setDirection(String direction, String range) {
        directions.put(direction, range);
    }

    public String getDirection(int degree) {
        for (Map.Entry<String, String> entry : directions.entrySet()) {
            String[] ranges = entry.getValue().split("-");
            int start = Integer.parseInt(ranges[0]);
            int end = Integer.parseInt(ranges[1]);
            if ((start <= degree && degree <= end) || (start > end && (degree >= start || degree <= end))) {
                return entry.getKey();
            }
        }
        return "Unknown";
    }
}