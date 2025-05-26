package com.tests.repositories;

import com.tests.models.modelsOracle.Actor;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ActorRepository implements PanacheRepository<Actor> {

}
