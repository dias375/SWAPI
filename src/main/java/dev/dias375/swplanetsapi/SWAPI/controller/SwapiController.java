package dev.dias375.swplanetsapi.SWAPI.controller;

import dev.dias375.swplanetsapi.SWAPI.model.Planet;
import dev.dias375.swplanetsapi.SWAPI.service.SwapiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class SwapiController {

    private final SwapiService swapiService;

    public SwapiController (SwapiService swapiService){
        this.swapiService = swapiService;
    }

    @GetMapping("/planets")
    public ResponseEntity<List<Planet>> getPlanets(){
        return ResponseEntity.ok(swapiService.getPlanets());
    }
}
