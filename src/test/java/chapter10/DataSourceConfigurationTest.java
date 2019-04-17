package chapter10;

import chapter10.db.SpitterRepository;
import chapter10.domain.Spitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JdbcConfiguration.class)
public class DataSourceConfigurationTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SpitterRepository spitterRepository;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Test
    public void testH2DataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void testJdbcTemplate() {
        assertNotNull(jdbcTemplate);
    }

    @Test
    public void testJdbCRepository() {

        Spitter expected = new Spitter(1, "user", "passw", "userFullName");
        spitterRepository.addSpitter(expected);
        Spitter actual = spitterRepository.findOne(1);

        assertNotNull(expected);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getFullName(), actual.getFullName());
        assertEquals(expected.getUserName(), actual.getUserName());
        assertEquals(expected.getPassword(), actual.getPassword());

    }

}