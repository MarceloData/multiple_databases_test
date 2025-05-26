package com.tests.services;

import com.tests.repositories.ActorRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ActorService {

    @Inject
    ActorRepository actorRepository;

    public Long actorNumbers() {
        return actorRepository.count();
    }
}
