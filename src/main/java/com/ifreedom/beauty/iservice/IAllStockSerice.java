package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.AllStockEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:05/12/2016
 * @todo:
 */
public interface IAllStockSerice {
    boolean saveAll(List<AllStockEntity> allStockEntityList);

    List<AllStockEntity> getAllStock();
}
