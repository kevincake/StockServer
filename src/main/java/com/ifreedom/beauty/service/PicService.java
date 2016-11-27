package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.PicEntity;
import com.ifreedom.beauty.iservice.IPicService;
import com.ifreedom.beauty.repository.PicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/25/16
 * @todo:
 */
@Service
public class PicService implements IPicService{
    @Autowired
    PicRepository picRepository;
    @Override
    public PicEntity addPic(PicEntity picEntity) {
        return picRepository.addPic(picEntity);
    }

    @Override
    public PicEntity deletePic(PicEntity picEntity) {
        return picRepository.deletePic(picEntity);
    }

    @Override
    public List<String> getPictures(int type, Long id) {

        return picRepository.getPictures(type,id);
    }
}
