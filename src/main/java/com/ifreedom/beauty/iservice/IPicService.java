package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.PicEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/25/16
 * @todo:
 */
public interface IPicService {
    public PicEntity addPic(PicEntity picEntity);
    public PicEntity deletePic(PicEntity picEntity);

    List<String> getPictures(int type, Long id);
}
