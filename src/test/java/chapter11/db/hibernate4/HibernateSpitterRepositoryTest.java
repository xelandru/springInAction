package chapter11.db.hibernate4;

import chapter11.HibernateConfiguration;
import chapter11.db.SpitterRepository;
import chapter11.domain.Spitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class)
public class HibernateSpitterRepositoryTest {

    @Autowired
    SpitterRepository spitterRepository;


    @Test
    @Transactional
    public void testHibernateRepository() {

        Spitter spitter = new Spitter(1, "user", "pass", "name");
        Spitter saved = spitterRepository.save(spitter);
        assertEquals(spitter, saved);
        assertEquals(1, spitterRepository.count());
        assertEquals(spitter, spitterRepository.findOne(1));
        assertEquals(spitter, spitterRepository.findByUsername("user"));
        assertEquals(spitter, spitterRepository.findAll().get(0));


    }

}