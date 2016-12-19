package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.SMAEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:12/12/2016
 * @todo:
 */
@Component
public class SMARepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public boolean saveSMA(SMAEntity smaEntity) {
        if (smaEntity == null) {
            return false;
        }
        entityManager.merge(smaEntity);
        return true;
    }

    public List<SMAEntity> getAll() {
        String sql = "SELECT * FROM sma WHERE ma5 != -1";
        Query nativeQuery = entityManager.createNativeQuery(sql, SMAEntity.class);
        return nativeQuery.getResultList();
    }
}
