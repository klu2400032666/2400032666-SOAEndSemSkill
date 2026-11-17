package com.tourist.controller;

import com.tourist.model.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final Map<Long, Hotel> hotels = new ConcurrentHashMap<>();

    public HotelController() {
        hotels.put(1L, new Hotel(1L, "Green Park Hotel", "Vijayawada", 2500));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable Long id, @RequestBody Hotel updatedHotel) {
        Hotel existing = hotels.get(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setName(updatedHotel.getName());
        existing.setLocation(updatedHotel.getLocation());
        existing.setPricePerNight(updatedHotel.getPricePerNight());
        return ResponseEntity.ok(Map.of(
                "message", "Hotel details updated successfully",
                "hotel", existing));
    }
}