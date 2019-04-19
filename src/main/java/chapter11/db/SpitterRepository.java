package chapter11.db;

import chapter11.domain.Spitter;

import java.util.List;

public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
