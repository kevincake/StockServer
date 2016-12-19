package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.StrategyEntity;
import com.ifreedom.beauty.iservice.IStrategyService;
import com.ifreedom.beauty.repository.StrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:12/12/2016
 * @todo:策略服务
 */
@Service
public class StrategyService implements IStrategyService{
    @Autowired
    StrategyRepository strategyRepository;
    @Override
    public List<StrategyEntity> getAll() {
        return strategyRepository.getAll();
    }

    @Override
    public boolean saveAll() {
        return false;
    }

    @Override
    public StrategyEntity addOrUpdate(StrategyEntity strategyEntity) {
        return strategyRepository.add(strategyEntity);
    }

    @Override
    public StrategyEntity get(String strategyId) {
        return strategyRepository.get(strategyId);
    }

    @Override
    public StrategyEntity delete(StrategyEntity strategyEntity) {
        return strategyRepository.delete(strategyEntity);
    }


}
