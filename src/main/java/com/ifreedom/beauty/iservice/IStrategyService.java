package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.StrategyEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:12/12/2016
 * @todo:
 */
public interface IStrategyService {
    List<StrategyEntity> getAll();
    boolean saveAll();

    StrategyEntity addOrUpdate(StrategyEntity strategyEntity);

    StrategyEntity get(String strategyId);

    StrategyEntity delete(StrategyEntity strategyEntity);
}
