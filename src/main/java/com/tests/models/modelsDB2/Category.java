package com.tests.models.modelsDB2;

import java.time.LocalDate;

import com.tests.enums.FilmCategory;

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
@Table(name = "CATEGORY", schema = "DB2INST1")
@Entity
public class Category extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "smallint")
    Long categoryId;

    @Column(name = "name", columnDefinition = "varchar(25)")
    FilmCategory name;

    @Column(name = "last_update")
    LocalDate lastUpdate;
}
