package com.tests.repositories;

import com.tests.models.modelsDB2.Film;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FilmRepository implements PanacheRepository<Film> {

}
