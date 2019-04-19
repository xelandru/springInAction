package chapter11.db.hibernate4;

import chapter11.db.SpitterRepository;
import chapter11.domain.Spitter;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Repository
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpitterRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Spitter save(Spitter spitter) {

        Serializable id = currentSession().save(spitter);
        return new Spitter((Long) id,
                spitter.getUserName(),
                spitter.getPassword(),
                spitter.getFullName());
    }

    @Override
    public Spitter findOne(long id) {

        return (Spitter) currentSession().get(Spitter.class, id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) currentSession()
                .createCriteria(Spitter.class)
                .add(Restrictions.eq("userName", username))
                .list().get(0);
    }

    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) currentSession()
                .createCriteria(Spitter.class).list();
    }
}
