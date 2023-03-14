package io.github.nilsonsasaki.user.persistence.dao;

import io.github.nilsonsasaki.user.persistence.entity.DatabaseUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserDaoTest {

    @Autowired
    UserDao repository;

    @Test
    public void should_find_no_user_if_repository_is_empty() {
        List<DatabaseUser> users = repository.findAll();
        assertTrue (users.isEmpty());
    }

    @Test
    public void should_store_user() {
        DatabaseUser user = repository.save(new DatabaseUser(
                1L,
                "externalId",
                "name",
                "email",
                "role",
                LocalDateTime.of(2023, Month.JANUARY, 24, 23, 59),
                LocalDateTime.of(2023, Month.MAY, 24, 23, 59)));
        assertEquals(Optional.of(user),repository.findById(user.getId()));
    }

    @Test
    public void should_find_user_by_id() {
        DatabaseUser user = repository.save(new DatabaseUser(
                1L,
                "externalId",
                "name",
                "email",
                "role",
                LocalDateTime.of(2023, Month.JANUARY, 24, 23, 59),
                LocalDateTime.of(2023, Month.MAY, 24, 23, 59)));
        Optional<DatabaseUser> persistedUser = repository.findById(user.getId());
        assertEquals(Optional.of(user),persistedUser);
    }

    @Test
    public void should_find_user_by_externalId() {
        DatabaseUser user = repository.save(new DatabaseUser(
                1L,
                "externalId",
                "name",
                "email",
                "role",
                LocalDateTime.of(2023, Month.JANUARY, 24, 23, 59),
                LocalDateTime.of(2023, Month.MAY, 24, 23, 59)));
        Optional<DatabaseUser> persistedUser  = repository.findByExternalId(user.getExternalId());
        assertEquals(Optional.of(user),persistedUser);
    }

    @Test
    public void should_find_user_by_email() {
        DatabaseUser user = repository.save(new DatabaseUser(
                1L,
                "externalId",
                "name",
                "email",
                "role",
                LocalDateTime.of(2023, Month.JANUARY, 24, 23, 59),
                LocalDateTime.of(2023, Month.MAY, 24, 23, 59)));
        Optional<DatabaseUser> persistedUser  = repository.findByEmail(user.getEmail());
        assertEquals(Optional.of(user),persistedUser);
    }

    @Test
    public void should_find_all_users(){
        DatabaseUser user = repository.save(new DatabaseUser(
                1L,
                "externalId",
                "name",
                "email",
                "role",
                LocalDateTime.of(2023, Month.JANUARY, 24, 23, 59),
                LocalDateTime.of(2023, Month.MAY, 24, 23, 59)));
        DatabaseUser user2 = repository.save(new DatabaseUser(
                2L,
                "externalId2",
                "name",
                "email2",
                "role",
                LocalDateTime.of(2023, Month.JANUARY, 24, 23, 59),
                LocalDateTime.of(2023, Month.MAY, 24, 23, 59)));
        List<DatabaseUser> users = repository.findAll();
        assertEquals(2,users.size());
        assertTrue(users.contains(user));
        assertTrue(users.contains(user2));
    }

    @Test
    public void should_attest_email_existence(){
        DatabaseUser user = repository.save(new DatabaseUser(
                1L,
                "externalId",
                "name",
                "email",
                "role",
                LocalDateTime.of(2023, Month.JANUARY, 24, 23, 59),
                LocalDateTime.of(2023, Month.MAY, 24, 23, 59)));
        repository.save(user);
        assertTrue(repository.existsByEmail(user.getEmail()));
    }

    @Test
    public void should_attest_externalId_existence(){
        DatabaseUser user = repository.save(new DatabaseUser(
                1L,
                "externalId",
                "name",
                "email",
                "role",
                LocalDateTime.of(2023, Month.JANUARY, 24, 23, 59),
                LocalDateTime.of(2023, Month.MAY, 24, 23, 59)));
        repository.save(user);
        assertTrue(repository.existsByExternalId(user.getExternalId()));
    }

}
