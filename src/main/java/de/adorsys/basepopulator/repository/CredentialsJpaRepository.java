package de.adorsys.basepopulator.repository;

import de.adorsys.basepopulator.db.model.mbs.MbsCredentialPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsJpaRepository extends JpaRepository<MbsCredentialPO, Long> {
}
