package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.bean.SocialDetailBean;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.CommentEntity;
import com.ifreedom.beauty.entity.LikeEntity;
import com.ifreedom.beauty.entity.SocialEntity;
import com.ifreedom.beauty.service.*;
import com.ifreedom.beauty.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/14/16
 * @todo:
 */
@Component
public class SocialRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    FollowService followService;
    @Autowired
    LikeService likeService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    PicService picService;


    public List<SocialDetailBean> getSocialDetails(Long userid) {

//        List<Long> followIds = followService.getFollowIds(userid);
//        if (followIds == null || followIds.isEmpty()) {
//            return null;
//        }
//        String inParamByIds = StringUtils.getInParamByIds(followIds);
        String sql = "select * from social";
        Query nativeQuery = entityManager.createNativeQuery(sql, SocialEntity.class);
        List<SocialEntity> resultList = nativeQuery.getResultList();
        return getSocialDetails(resultList);
    }


    public LikeEntity likeSocial(Long userId, Long socialId) {
        return null;
    }

    public SocialDetailBean getSocialDetail(Long socialId) {
        SocialEntity social = getSocial(socialId);
        return getSocialDetail(social);
    }

    private SocialDetailBean getSocialDetail(SocialEntity socialEntity) {
        SocialDetailBean socialDetailBean = new SocialDetailBean();
        socialDetailBean.setSocialEntity(socialEntity);
        List<LikeEntity> likes = likeService.getLikes(socialEntity.getId());
        socialDetailBean.setLikeEntities(likes);
        List<CommentEntity> comments = commentService.getComments(socialEntity.getId());
        socialDetailBean.setCommentsEntities(comments);
        socialDetailBean.setUser(userService.getUser(socialEntity.getUserId()));
        List<String> pictures = picService.getPictures(DataBaseConstants.SOCIAL_TYPE, socialEntity.getId());
        socialEntity.setPic(pictures);
        return socialDetailBean;
    }

    private List<SocialDetailBean> getSocialDetails(final List<SocialEntity> socialEntities) {
        List<SocialDetailBean> socialDetailBeans = new ArrayList<>();
        for (SocialEntity socialEntity :
                socialEntities) {
            socialDetailBeans.add(getSocialDetail(socialEntity));
        }
        return socialDetailBeans;
    }

    public SocialEntity getSocial(Long socialId) {
        return entityManager.find(SocialEntity.class, socialId);
    }

    public SocialEntity updateSocialDetail(SocialEntity socialEntity) {
        return null;
    }

    public SocialDetailBean deleteSocialDetail(Long detailId) {
        return null;
    }

    @Transactional
    public SocialEntity addSocial(SocialEntity socialEntity) {
        return entityManager.merge(socialEntity);
    }

    public List<SocialDetailBean> getMineSocial(Long userId) {
        String sql = "select * from social where userId = :userId";
        Query nativeQuery = entityManager.createNativeQuery(sql, SocialEntity.class);
        nativeQuery.setParameter(DataBaseConstants.USER_ID, userId);
        List<SocialEntity> resultList = nativeQuery.getResultList();
        return getSocialDetails(resultList);
    }
}
