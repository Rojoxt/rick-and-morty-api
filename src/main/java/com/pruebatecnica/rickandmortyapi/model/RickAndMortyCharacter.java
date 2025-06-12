package com.pruebatecnica.rickandmortyapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RickAndMortyCharacter {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private LocationInfo origin;
    private LocationInfo location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

}

@Getter
@Setter
class LocationInfo {
    private String name;
    private String url;
}



