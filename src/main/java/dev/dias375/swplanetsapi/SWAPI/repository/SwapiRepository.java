package dev.dias375.swplanetsapi.SWAPI.repository;

import dev.dias375.swplanetsapi.SWAPI.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SwapiRepository extends JpaRepository<Planet, UUID> {

    @Query(
           value = "SELECT * FROM PLANETS",
           nativeQuery = true
    )
    List<Planet> getPlanets();
}
