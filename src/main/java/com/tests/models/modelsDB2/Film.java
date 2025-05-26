package com.tests.models.modelsDB2;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "FILM", schema = "DB2INST1")
@Entity
public class Film extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", columnDefinition = "integer")
    private Long filmId;

    private String title;

    @Column(name = "description", columnDefinition = "clob")
    private String Description;

    @Column(name = "release_year")
    private String releaseYear;

    @Column(name = "language_id", columnDefinition = "smallint")
    private Integer languadeId;

    @Column(name = "original_language_id", columnDefinition = "smallint")
    private Integer originalLanguageId;

    @Column(name = "rental_duration", columnDefinition = "smallint")
    private Integer rentalDuration;

    @Column(name = "rental_rate", columnDefinition = "decimal")
    private Float rentalRate;

    @Column(name = "length", columnDefinition = "smallint")
    private Integer length;

    @Column(name = "replacement_cost", columnDefinition = "decimal")
    private Float replacementCost;
    private String rating;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
