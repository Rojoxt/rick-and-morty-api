package com.pruebatecnica.rickandmortyapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebatecnica.rickandmortyapi.client.CharacterClient;
import com.pruebatecnica.rickandmortyapi.model.RickAndMortyCharacter;
import com.pruebatecnica.rickandmortyapi.shared.response.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CharacterService {
    private final CharacterClient characterClient;

    public CharacterService(CharacterClient characterClient) {
        this.characterClient = characterClient;
    }

    // Esto optiene el mismo formato que te da la la url info + result
    public ApiResponse<RickAndMortyCharacter> getCharacters() {
        return characterClient.getAll();
    }

    //Esto obtiene solo la lista de character no su info
    /*public List<RickAndMortyCharacter> getCharacters() {
        return characterClient.getAll().getResults();
    }*/

    public RickAndMortyCharacter getCharacter(int id) {
        return characterClient.getById(id);
    }
    public ApiResponse<RickAndMortyCharacter> getCharacters(String name, String status, String species, String type, String gender, int page) {
        return characterClient.getCharactersFiltered(name, status, species, type, gender, page);
    }
    public List<RickAndMortyCharacter> getMultipleCharactersByIds(String ids) {
        List<RickAndMortyCharacter> result = characterClient.getMultipleIds(ids);

        if (result != null) {
            return result;
        } else {
            RickAndMortyCharacter singleCharacter = new ObjectMapper().convertValue(result, RickAndMortyCharacter.class);
            return List.of(singleCharacter);
        }
    }
}
