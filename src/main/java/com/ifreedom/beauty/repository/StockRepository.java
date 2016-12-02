package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.authorization.annotation.CurrentUser;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.FollowEntity;
import com.ifreedom.beauty.entity.SocialEntity;
import com.ifreedom.beauty.entity.StockEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:26/11/2016
 * @todo:
 */
@Component
public class StockRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public StockEntity addStock(StockEntity stockEntity) {
        if (stockEntity == null) {
            return null;
        }
        return entityManager.merge(stockEntity);
    }

    @Transactional
    public StockEntity deleteStock(long id) {
        StockEntity stockEntity = entityManager.find(StockEntity.class, id);
        if (stockEntity != null) {
            entityManager.remove(stockEntity);
        }
        return stockEntity;
    }

    @Transactional
    public StockEntity updateStock(StockEntity stockEntity) {
        if (stockEntity == null) {
            return null;
        }
        return entityManager.merge(stockEntity);
    }

    public StockEntity query(long id) {
        String sql = "select * from stock where id = :id";
        Query nativeQuery = entityManager.createNativeQuery(sql, StockEntity.class);
        nativeQuery.setParameter(DataBaseConstants.ID, id);
        List<StockEntity> resultList = nativeQuery.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

    public StockEntity queryByStockCode(String stockCode) {
        String sql = "select * from stock where stockCode = :stockCode";
        Query nativeQuery = entityManager.createNativeQuery(sql, StockEntity.class);
        nativeQuery.setParameter("stockCode", stockCode);
        List<StockEntity> resultList = nativeQuery.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

    public List<StockEntity> queryMyAllStocks(
            Long userId) {
        String sql = "select * from stock where userId = :userId";
        Query nativeQuery = entityManager.createNativeQuery(sql, StockEntity.class);
        nativeQuery.setParameter("userId", userId);
        List<StockEntity> resultList = nativeQuery.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList;
        }
    }
}



