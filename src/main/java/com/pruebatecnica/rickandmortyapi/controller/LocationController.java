package com.pruebatecnica.rickandmortyapi.controller;

import com.pruebatecnica.rickandmortyapi.model.Location;
import com.pruebatecnica.rickandmortyapi.service.LocationService;
import com.pruebatecnica.rickandmortyapi.shared.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<Location>> getEpisodes(@RequestParam(required = false) String name,
                                                            @RequestParam(required = false) String episode,
                                                            @RequestParam(required = false) String dimension,
                                                            @RequestParam(defaultValue = "1") int page) {
        ApiResponse<Location> response =   locationService.getLocations(name, episode, dimension, page);

        return ResponseEntity.ok(response);
    }



    @GetMapping("/{ids}")
    public ResponseEntity<?> getEpisodesByIds(@PathVariable String ids) {
        if (!ids.contains(",")) {

            Location location = locationService.getLocation(Integer.parseInt(ids));
            return ResponseEntity.ok(location);
        } else {
            List<Location> Locations = locationService.getMultipleLocationsByIds(ids);
            return ResponseEntity.ok(Locations);
        }
    }
}
