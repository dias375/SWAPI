package dev.dias375.swplanetsapi.SWAPI.service;

import dev.dias375.swplanetsapi.SWAPI.model.Planet;
import dev.dias375.swplanetsapi.SWAPI.repository.SwapiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SwapiService {

    private final SwapiRepository swapiRepository;

    public SwapiService(SwapiRepository swapiRepository) {
        this.swapiRepository = swapiRepository;
    }

    public List<Planet> getPlanets(){
        return swapiRepository.getPlanets();
    }
}
