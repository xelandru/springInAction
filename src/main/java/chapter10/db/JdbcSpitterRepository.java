package chapter10.db;

import chapter10.domain.Spitter;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private static final String INSERT_SPITTER = "INSERT INTO spitter(id, username, password, fullname) VALUES (?, ?, ?, ?)";

    private static final String FIND_SPITTER = "SELECT id, username, password, fullname FROM spitter WHERE id = ?";

    @Inject
    private JdbcOperations jdbcOperations;

    public JdbcSpitterRepository() {
    }

    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void addSpitter(Spitter spitter) {

        jdbcOperations.update(INSERT_SPITTER,
                spitter.getId(),
                spitter.getUserName(),
                spitter.getPassword(),
                spitter.getFullName());
    }

    @Override
    public Spitter findOne(long id) {
        return jdbcOperations.queryForObject(FIND_SPITTER, new SpitterRowMapper(), id);
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {

        @Override
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("fullname"));
        }
    }
}