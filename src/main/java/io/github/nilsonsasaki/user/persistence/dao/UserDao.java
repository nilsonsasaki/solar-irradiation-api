package io.github.nilsonsasaki.user.persistence.dao;

import io.github.nilsonsasaki.user.persistence.entity.DatabaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<DatabaseUser,Long> {

    Optional<DatabaseUser> findByExternalId(String externalId);

    Optional<DatabaseUser> findByEmail (String email);

    boolean existsByEmail(String email);

    boolean existsByExternalId(String externalId);
}
