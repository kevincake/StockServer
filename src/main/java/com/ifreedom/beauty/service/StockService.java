package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.StockEntity;
import com.ifreedom.beauty.iservice.IStockService;
import com.ifreedom.beauty.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @atuhor:eavawu
 * @date:26/11/2016
 * @todo:
 */
@Service
public class StockService implements IStockService{
    @Autowired
    StockRepository stockRepository;
    @Override
    public StockEntity addStock(StockEntity stockEntity) {
        return stockRepository.addStock(stockEntity);
    }

    @Override
    public StockEntity deleteStock(long id) {
        return stockRepository.deleteStock(id);
    }

    @Override
    public StockEntity updateStock(StockEntity stockEntity) {
        return stockRepository.updateStock(stockEntity);
    }

    @Override
    public StockEntity query(long id) {
        return stockRepository.query(id);
    }
}
