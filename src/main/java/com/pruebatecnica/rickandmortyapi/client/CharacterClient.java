package com.pruebatecnica.rickandmortyapi.client;

import com.pruebatecnica.rickandmortyapi.model.RickAndMortyCharacter;
import com.pruebatecnica.rickandmortyapi.shared.client.BaseClient;
import com.pruebatecnica.rickandmortyapi.shared.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "character-client", url = "https://rickandmortyapi.com/api/character")
public interface CharacterClient extends BaseClient<RickAndMortyCharacter> {

    @GetMapping
    ApiResponse<RickAndMortyCharacter> getCharactersFiltered(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String status,
                                      @RequestParam(required = false) String species,
                                      @RequestParam(required = false) String type,
                                      @RequestParam(required = false) String gender,
                                      @RequestParam(defaultValue = "1") int page);

}
