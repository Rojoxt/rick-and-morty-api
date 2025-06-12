package com.pruebatecnica.rickandmortyapi.shared.response;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse <T>{
    private InfoResponse info;
    private List<T> results;
}

