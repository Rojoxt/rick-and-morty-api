package com.pruebatecnica.rickandmortyapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebatecnica.rickandmortyapi.client.EpisodeClient;
import com.pruebatecnica.rickandmortyapi.model.Episode;
import com.pruebatecnica.rickandmortyapi.model.RickAndMortyCharacter;
import com.pruebatecnica.rickandmortyapi.shared.response.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {
    private final EpisodeClient episodeClient;

    public EpisodeService(EpisodeClient episodeClient) {
        this.episodeClient = episodeClient;
    }

    public ApiResponse<Episode> getEpisodes() {
        return episodeClient.getAll();
    }
    public Episode getEpisode(int id) {
        return episodeClient.getById(id);
    }

    public ApiResponse<Episode> getCharacters(String name, String episode, int page) {
        return episodeClient.getEpisodesFiltered(name, episode, page);
    }
    public List<Episode> getMultipleCharactersByIds(String ids) {
        List<Episode> result = episodeClient.getMultipleIds(ids);

        if (result != null) {
            return result;
        } else {
            Episode singleCharacter = new ObjectMapper().convertValue(result, Episode.class);
            return List.of(singleCharacter);
        }
    }



}
