package com.pruebatecnica.rickandmortyapi.controller;

import com.pruebatecnica.rickandmortyapi.model.RickAndMortyCharacter;
import com.pruebatecnica.rickandmortyapi.service.CharacterService;
import com.pruebatecnica.rickandmortyapi.shared.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/character")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<RickAndMortyCharacter>> getCharacters(@RequestParam(required = false) String name,
                                                                            @RequestParam(required = false) String status,
                                                                            @RequestParam(required = false) String species,
                                                                            @RequestParam(required = false) String type,
                                                                            @RequestParam(required = false) String gender,
                                                                            @RequestParam(defaultValue = "1") int page) {
        ApiResponse response =   characterService.getCharacters(name, status, species, type, gender, page);

        return ResponseEntity.ok(response);
    }

    // antigua implemetacion de getbyID
    /*@GetMapping("/{id}")
    public ResponseEntity<RickAndMortyCharacter> getCharacterById(@PathVariable("id") int id) {
        return ResponseEntity.ok(characterService.getCharacter(id));
    }
*/

    @GetMapping("/{ids}")
    public ResponseEntity<?> getCharactersByIds(@PathVariable String ids) {
        if (!ids.contains(",")) {
            // Solo un ID, devolvemos un solo character
            RickAndMortyCharacter character = characterService.getCharacter(Integer.parseInt(ids));
            return ResponseEntity.ok(character);
        } else {
            // Múltiples IDs, devolvemos una lista < character>
            List<RickAndMortyCharacter> characters = characterService.getMultipleCharactersByIds(ids);
            return ResponseEntity.ok(characters);
        }
    }






}
