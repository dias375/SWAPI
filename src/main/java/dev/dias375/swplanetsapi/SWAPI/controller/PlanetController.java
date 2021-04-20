package dev.dias375.swplanetsapi.SWAPI.controller;

import dev.dias375.swplanetsapi.SWAPI.model.Planet;
import dev.dias375.swplanetsapi.SWAPI.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private PlanetService planetService;

    @GetMapping
    public List<Planet> listPlanets() {
        return planetService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Planet> add(@Valid @RequestBody Planet planet) {
        if (planetNameDoesNotExist(planet.getName())) {
            planetService.save(planet);
            return ResponseEntity.status(HttpStatus.CREATED).body(planet);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{planetId}")
    public ResponseEntity<Optional<Planet>> delete(@PathVariable Long planetId) {
        if (planetIdAlreadyExists(planetId)) {
            Optional<Planet> deletedPlanet = planetService.findById(planetId);
            planetService.delete(planetId);
            return ResponseEntity.ok().body(deletedPlanet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{planetId}")
    public ResponseEntity<Planet> update(@Valid @PathVariable long planetId,
                                         @RequestBody Planet planet) {
        if (planetIdAlreadyExists(planetId)) {
            planet.setId(planetId);
            planet = planetService.save(planet);
            return ResponseEntity.ok().body(planet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private Boolean planetIdAlreadyExists(long planetId) {
        return planetService.planetAlreadyExists(planetId);
    }

    private Boolean planetNameDoesNotExist(String planetName) {
        return planetService.planetNameDoesNotExist(planetName);
    }

    //TODO refactor exists methods into a single check method
    //Responsibility from service or controller? Abstract from controller?


}
