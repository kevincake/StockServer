package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.AllStockHistoryEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:07/12/2016
 * @todo:
 */
public interface IAllStockHistoryService {
    List<AllStockHistoryEntity> getAllStockHistoryFromNetwork();

    boolean saveAll(List<AllStockHistoryEntity> allStockHistory);

    public List<AllStockHistoryEntity> getRecentstHistory(String code, int beginIndex, int count);
}


