package de.adorsys.basepopulator.repository;

import de.adorsys.basepopulator.db.model.mbs.LoginSettingsPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginSettingsJpaRepository extends JpaRepository<LoginSettingsPO, Long> {
}
