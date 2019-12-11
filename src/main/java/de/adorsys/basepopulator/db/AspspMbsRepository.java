package de.adorsys.basepopulator.db;

import de.adorsys.basepopulator.db.model.AspspMbsEntity;

import java.util.List;

public interface AspspMbsRepository {

    void saveAll(List<AspspMbsEntity> aspsps);
}
