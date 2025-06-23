package org.ashara.chennai.transport.tripsheet.repository;

import org.ashara.chennai.transport.tripsheet.entities.ColdStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColdStorageRepository extends JpaRepository<ColdStorage, Integer> {
}
