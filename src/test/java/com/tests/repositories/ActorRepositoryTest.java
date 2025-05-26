package com.tests.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.tests.models.modelsOracle.Actor;
import com.tests.profiles.OracleProfile;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@QuarkusTest
@TestProfile(OracleProfile.class)
public class ActorRepositoryTest {

    @Inject
    ActorRepository actorRepository;

    @Test
    public void testFindAllActors() {
        List<Actor> actors = actorRepository.listAll();
        assertNotNull(actors);
        assertEquals(3, actors.size());
        assertEquals("PENELOPE", actors.get(0).getFirstName());
    }

    @Test
    @Transactional
    public void testAddActor() {
        Actor newActor = new Actor();
        // newActor.setActorId(4L);
        newActor.setFirstName("Alice");
        newActor.setLastName("Brown");
        newActor.setLastUpdate(LocalDate.now());

        actorRepository.persist(newActor);

        Actor found = actorRepository.findById(4L);
        assertNotNull(found);
        assertEquals("Alice", found.getFirstName());
        actorRepository.deleteById(4L);
    }

    @Test
    public void testCountAllActors() {
        long count = actorRepository.count();
        assertEquals(3, count, "Expected 3 actors in total");
    }
}
