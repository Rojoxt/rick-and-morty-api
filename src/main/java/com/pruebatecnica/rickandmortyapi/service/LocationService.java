package com.pruebatecnica.rickandmortyapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebatecnica.rickandmortyapi.client.LocationClient;
import com.pruebatecnica.rickandmortyapi.model.Location;
import com.pruebatecnica.rickandmortyapi.shared.response.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationClient locationClient;

    public LocationService(LocationClient locationClient) {
        this.locationClient = locationClient;
    }

    public ApiResponse<Location> getLocations() {
        return locationClient.getAll();
    }
    public Location getLocation(int id) {
        return locationClient.getById(id);
    }

    public ApiResponse<Location> getLocations(String name, String episode, String dimension, int page) {
        return locationClient.getLocationsFiltered(name, episode, dimension,page);
    }
    public List<Location> getMultipleLocationsByIds(String ids) {
        List<Location> result = locationClient.getMultipleIds(ids);

        if (result != null) {
            return result;
        } else {
            Location singleCharacter = new ObjectMapper().convertValue(result, Location.class);
            return List.of(singleCharacter);
        }
    }
}
