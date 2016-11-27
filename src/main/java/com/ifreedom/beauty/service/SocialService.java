package com.ifreedom.beauty.service;

import com.ifreedom.beauty.bean.SocialDetailBean;
import com.ifreedom.beauty.entity.LikeEntity;
import com.ifreedom.beauty.entity.SocialEntity;
import com.ifreedom.beauty.iservice.ISocialService;
import com.ifreedom.beauty.repository.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/14/16
 * @todo:
 */
@Service
public class SocialService implements ISocialService {
    @Autowired
    SocialRepository socialRepository;


    @Override
    public List<SocialDetailBean> getSocialDetails(Long userid) {
        return socialRepository.getSocialDetails(userid);
    }

    @Override
    public LikeEntity likeSocial(Long userId, Long socialId) {
        return socialRepository.likeSocial(userId,socialId);
    }

    @Override
    public SocialDetailBean getSocialDetail(Long socialId) {
        return socialRepository.getSocialDetail(socialId);
    }

    @Override
    public SocialEntity getSocial(Long socialId) {
        return socialRepository.getSocial(socialId);
    }

    @Override
    public SocialEntity updateSocialDetail(SocialEntity socialEntity) {
        return socialRepository.updateSocialDetail(socialEntity);
    }



    @Override
    public SocialDetailBean deleteSocailDetail(Long detailId) {
        return socialRepository.deleteSocialDetail(detailId);
    }

    @Override
    public SocialEntity addSocial(SocialEntity socialEntity) {
        return socialRepository.addSocial(socialEntity);
    }

    @Override
    public List<SocialDetailBean> getMineSocial(Long userId) {
        return  socialRepository.getMineSocial(userId);
    }
}
