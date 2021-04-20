package dev.dias375.swplanetsapi.SWAPI.service;

import dev.dias375.swplanetsapi.SWAPI.dao.PlanetDAO;
import dev.dias375.swplanetsapi.SWAPI.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    @Autowired
    private PlanetDAO planetDAO;

    public Planet save(Planet planet) {
        return planetDAO.save(planet);
    }

    public void delete(Long planetId) {
        planetDAO.deleteById(planetId);
    }

    public List<Planet> findAll() {
        return planetDAO.findAll();
    }

    public Optional<Planet> findById(long planetId) {
        return planetDAO.findById(planetId);
    }

    public Boolean planetNameDoesNotExist(String planetName) {
        List<Planet> existingPlanetsWithTheSameName = planetDAO.findByName(planetName);
        return existingPlanetsWithTheSameName.isEmpty();
    }

    public Boolean planetAlreadyExists(long planetId) {
        return planetDAO.existsById(planetId);
    }
}
