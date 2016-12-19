package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.SMAEntity;
import com.ifreedom.beauty.iservice.IMAService;
import com.ifreedom.beauty.repository.SMARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:12/12/2016
 * @todo:
 */
@Component
public class MAService implements IMAService {
    @Autowired
    SMARepository smaRepository;
    @Override
    public boolean saveSMA(SMAEntity smaEntity) {
        return smaRepository.saveSMA(smaEntity);
    }

    @Override
    public List<SMAEntity> getAll() {
        return smaRepository.getAll();
    }



}
