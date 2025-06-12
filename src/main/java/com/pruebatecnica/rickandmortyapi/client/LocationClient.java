package com.pruebatecnica.rickandmortyapi.client;

import com.pruebatecnica.rickandmortyapi.model.Location;
import com.pruebatecnica.rickandmortyapi.shared.client.BaseClient;
import com.pruebatecnica.rickandmortyapi.shared.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "location-client",url = "https://rickandmortyapi.com/api/location")
public interface LocationClient extends BaseClient<Location> {
    @GetMapping
    ApiResponse<Location> getLocationsFiltered(@RequestParam(required = false) String name,
                                                @RequestParam(required = false) String type,
                                               @RequestParam(required = false) String dimension,
                                               @RequestParam(defaultValue = "1") int page);
}
