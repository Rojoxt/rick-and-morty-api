package com.pruebatecnica.rickandmortyapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Character {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Object origin;
    private Object location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

}

@Getter
@Setter
class Object {
    private String name;
    private String url;
}



