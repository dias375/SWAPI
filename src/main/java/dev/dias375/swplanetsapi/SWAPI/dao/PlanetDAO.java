package dev.dias375.swplanetsapi.SWAPI.dao;

import dev.dias375.swplanetsapi.SWAPI.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetDAO extends JpaRepository<Planet, Long> {

    List<Planet> findByName(String name);

}
