package org.ashara.chennai.transport.tripsheet.repository;

import org.ashara.chennai.transport.tripsheet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByItsNumberAndIsActive(String itsNumber, Boolean isActive);
}
