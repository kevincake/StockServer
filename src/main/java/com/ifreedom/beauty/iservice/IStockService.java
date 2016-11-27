package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.StockEntity;

/**
 * @atuhor:eavawu
 * @date:26/11/2016
 * @todo:
 */
public interface IStockService {
    StockEntity addStock(StockEntity stockEntity);

    StockEntity deleteStock(long id); //数据库id

    StockEntity updateStock(StockEntity stockEntity);

    StockEntity query(long id);


}
