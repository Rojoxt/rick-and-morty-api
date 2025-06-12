package com.pruebatecnica.rickandmortyapi.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
public class Episode {
    private int id;
    private String name;
    private String airDate;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;

}
