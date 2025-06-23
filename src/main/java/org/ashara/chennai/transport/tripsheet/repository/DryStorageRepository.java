package org.ashara.chennai.transport.tripsheet.repository;

import org.ashara.chennai.transport.tripsheet.entities.DryStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DryStorageRepository extends JpaRepository<DryStorage, Integer> {
}
