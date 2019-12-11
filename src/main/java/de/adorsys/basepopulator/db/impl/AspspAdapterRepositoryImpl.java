package de.adorsys.basepopulator.db.impl;

import de.adorsys.basepopulator.db.AspspAdapterRepository;
import de.adorsys.basepopulator.db.model.AspspAdapterEntity;
import de.adorsys.basepopulator.repository.AspspAdapterJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AspspAdapterRepositoryImpl implements AspspAdapterRepository {

    private AspspAdapterJpaRepository repository;

    public AspspAdapterRepositoryImpl(AspspAdapterJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(List<AspspAdapterEntity> aspsps) {
        repository.saveAll(aspsps);
    }
}
