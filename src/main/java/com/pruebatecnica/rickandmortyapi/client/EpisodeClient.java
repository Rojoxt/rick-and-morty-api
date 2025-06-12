package com.pruebatecnica.rickandmortyapi.client;

import com.pruebatecnica.rickandmortyapi.model.Episode;
import com.pruebatecnica.rickandmortyapi.shared.client.BaseClient;
import com.pruebatecnica.rickandmortyapi.shared.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "episode-client",url = "https://rickandmortyapi.com/api/episode")
public interface EpisodeClient extends BaseClient<Episode> {
    @GetMapping
    ApiResponse <Episode> getEpisodesFiltered(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String episode,
                                      @RequestParam(defaultValue = "1") int page);

}
