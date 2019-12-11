package de.adorsys.basepopulator.repository;

import de.adorsys.basepopulator.db.model.AspspAdapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AspspAdapterJpaRepository extends JpaRepository<AspspAdapterEntity, UUID> {
}
