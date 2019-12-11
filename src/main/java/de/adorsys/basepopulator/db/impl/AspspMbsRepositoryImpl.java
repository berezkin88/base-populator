package de.adorsys.basepopulator.db.impl;

import de.adorsys.basepopulator.db.AspspMbsRepository;
import de.adorsys.basepopulator.db.model.AspspMbsEntity;
import de.adorsys.basepopulator.repository.AspspMbsJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AspspMbsRepositoryImpl implements AspspMbsRepository {

    private AspspMbsJpaRepository repository;

    public AspspMbsRepositoryImpl(AspspMbsJpaRepository aspspMbsJpaRepository) {
        this.repository = aspspMbsJpaRepository;
    }

    @Override
    public void saveAll(List<AspspMbsEntity> aspsps) {
        repository.saveAll(aspsps);
    }
}
