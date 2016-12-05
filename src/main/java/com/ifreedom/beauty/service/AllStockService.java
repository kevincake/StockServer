package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.AllStockEntity;
import com.ifreedom.beauty.iservice.IAllStockSerice;
import com.ifreedom.beauty.repository.AllStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:05/12/2016
 * @todo:
 */
@Component
public class AllStockService implements IAllStockSerice {
    @Autowired
    AllStockRepository allStockRepository;

    @Override
    public boolean saveAll(List<AllStockEntity> allStockEntityList) {
        allStockRepository.clear();
        return allStockRepository.saveAll(allStockEntityList);
    }
}
