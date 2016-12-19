package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.SMAEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:12/12/2016
 * @todo:MA处理的service
 */
public interface IMAService {
    boolean saveSMA(SMAEntity smaEntity);

    List<SMAEntity> getAll();
}
