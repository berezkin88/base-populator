package de.adorsys.basepopulator.db;

import de.adorsys.basepopulator.db.model.AspspAdapterEntity;

import java.util.List;

public interface AspspAdapterRepository {

    void saveAll(List<AspspAdapterEntity> aspsps);
}
