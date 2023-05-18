package dev.dias375.swplanetsapi.SWAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PLANETS")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UUID")
    private UUID uuid;

    @Column(name = "PLANET_NAME")
    private String name;

    @Column(name = "CLIMATE")
    private String climate;

    @Column(name = "TERRAIN")
    private String terrain;
}
