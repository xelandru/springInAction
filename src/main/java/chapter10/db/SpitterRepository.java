package chapter10.db;

import chapter10.domain.Spitter;

public interface SpitterRepository {

    void addSpitter(Spitter spitter);

    Spitter findOne(long id);

}
