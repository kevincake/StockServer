package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.AllStockEntity;
import com.ifreedom.beauty.entity.ArticleEntity;
import com.ifreedom.beauty.entity.LikeEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:05/12/2016
 * @todo:
 */
@Component
public class AllStockRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public boolean saveAll(List<AllStockEntity> allStockEntityList) {
        if (allStockEntityList == null) {
            return false;
        }
        clear();
        for (int i = 0; i < allStockEntityList.size(); i++) {
            entityManager.merge(allStockEntityList.get(i));
        }
        return true;
    }

    @Transactional
    public void clear() {
        String sql = "Truncate Table all_stock";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.executeUpdate();

    }
}
