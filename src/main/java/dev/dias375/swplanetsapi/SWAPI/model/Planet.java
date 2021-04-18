package dev.dias375.swplanetsapi.SWAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PLANETS")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long Id;

    @Column(name = "PLANET_NAME")
    private String name;

    @Column(name = "CLIMATE")
    private String climate;

    @Column(name = "TERRAIN")
    private String terrain;
}
