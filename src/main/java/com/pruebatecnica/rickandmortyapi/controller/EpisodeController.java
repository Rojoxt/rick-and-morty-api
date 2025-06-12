package com.pruebatecnica.rickandmortyapi.controller;

import com.pruebatecnica.rickandmortyapi.model.Episode;
import com.pruebatecnica.rickandmortyapi.service.EpisodeService;
import com.pruebatecnica.rickandmortyapi.shared.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/episode")
public class EpisodeController {
    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Episode>> getEpisodes(@RequestParam(required = false) String name,
                                                              @RequestParam(required = false) String episode,
                                                              @RequestParam(defaultValue = "1") int page) {
        ApiResponse<Episode> response =   episodeService.getCharacters(name, episode, page);

        return ResponseEntity.ok(response);
    }



    @GetMapping("/{ids}")
    public ResponseEntity<?> getEpisodesByIds(@PathVariable String ids) {
        if (!ids.contains(",")) {
            // Solo un ID, devolvemos un solo episode
            Episode episode = episodeService.getEpisode(Integer.parseInt(ids));
            return ResponseEntity.ok(episode);
        } else {
            // Múltiples IDs, devolvemos una lista < episode>
            List<Episode> episodes = episodeService.getMultipleCharactersByIds(ids);
            return ResponseEntity.ok(episodes);
        }
    }
}
