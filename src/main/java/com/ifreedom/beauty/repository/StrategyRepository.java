package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.SMAEntity;
import com.ifreedom.beauty.entity.StrategyEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:12/12/2016
 * @todo:策略数据库处理
 */
@Component
public class StrategyRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<StrategyEntity> getAll() {
        String sql = "SELECT * FROM strategy";
        Query nativeQuery = entityManager.createNativeQuery(sql, StrategyEntity.class);
        return nativeQuery.getResultList();
    }

    @Transactional
    public StrategyEntity add(StrategyEntity strategyEntity) {
        if (strategyEntity == null) {
            return null;
        }
        return entityManager.merge(strategyEntity);
    }

    @Transactional
    public StrategyEntity get(String strategyId) {
        return entityManager.find(StrategyEntity.class, Long.parseLong(strategyId));
    }

    @Transactional
    public StrategyEntity delete(StrategyEntity strategyEntity) {
        entityManager.remove(strategyEntity);
        return strategyEntity;
    }
}
