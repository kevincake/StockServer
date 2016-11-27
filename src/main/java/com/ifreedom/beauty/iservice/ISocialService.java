package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.bean.SocialDetailBean;
import com.ifreedom.beauty.entity.LikeEntity;
import com.ifreedom.beauty.entity.SocialEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/13/16
 * @todo:
 */
public interface ISocialService {
    List<SocialDetailBean> getSocialDetails(Long userid);
    LikeEntity likeSocial(Long userId, Long socialId);
    SocialDetailBean getSocialDetail(Long socialId);
    SocialEntity getSocial(Long socialId);
    SocialEntity updateSocialDetail(SocialEntity socialEntity);
    SocialDetailBean deleteSocailDetail(Long detailId);
    SocialEntity addSocial(SocialEntity socialEntity);


    List<SocialDetailBean> getMineSocial(Long userId);
}
