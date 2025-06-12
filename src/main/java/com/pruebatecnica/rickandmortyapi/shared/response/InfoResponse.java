package com.pruebatecnica.rickandmortyapi.shared.response;

import lombok.Data;

@Data
public class InfoResponse {
    private int count;
    private int pages;
    private String next;
    private String prev;
}