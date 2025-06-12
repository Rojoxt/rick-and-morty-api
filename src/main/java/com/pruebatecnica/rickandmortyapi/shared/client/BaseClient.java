package com.pruebatecnica.rickandmortyapi.shared.client;

import com.pruebatecnica.rickandmortyapi.shared.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BaseClient <T>{

    @GetMapping
    ApiResponse <T> getAll();

    @GetMapping("/{id}")
    T getById(@PathVariable("id") Integer id);

    @GetMapping("/{ids}")
    List<T> getMultipleIds(@PathVariable("ids") String ids);
}
