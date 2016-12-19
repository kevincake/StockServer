package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.AllStockHistoryEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:08/12/2016
 * @todo:操作股票所有历史数据的repository
 */
@Component
public class AllStockHistoryRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void clear() {
        String sql = "Truncate Table all_stock_history";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.executeUpdate();

    }

    @Transactional
    public boolean saveAll(List<AllStockHistoryEntity> allStockHistories) {
        if (allStockHistories == null) {
            return false;
        }
        clear();
        for (int i = 0; i < allStockHistories.size(); i++) {
            entityManager.merge(allStockHistories.get(i));
        }
        return true;
    }


    public List<AllStockHistoryEntity> getRecentstHistory(String code, int beginIndex, int count) {
        String sql = "SELECT * FROM all_stock_history WHERE  stockCode = :stockCode ORDER BY date";
        Query nativeQuery = entityManager.createNativeQuery(sql,AllStockHistoryEntity.class);
        nativeQuery.setFirstResult(beginIndex);
        nativeQuery.setMaxResults(count);
        nativeQuery.setParameter("stockCode", code);
        return nativeQuery.getResultList();
    }
}
