package com.ifreedom.beauty.bean;

import com.ifreedom.beauty.entity.CommentEntity;
import com.ifreedom.beauty.entity.LikeEntity;
import com.ifreedom.beauty.entity.SocialEntity;
import com.ifreedom.beauty.entity.UserEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/14/16
 * @todo:
 */
public class SocialDetailBean {
    private SocialEntity socialEntity;
    private List<LikeEntity> likeEntities;
    private List<CommentEntity> commentsEntities;
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public SocialEntity getSocialEntity() {
        return socialEntity;
    }

    public void setSocialEntity(SocialEntity socialEntity) {
        this.socialEntity = socialEntity;
    }

    public List<LikeEntity> getLikeEntities() {
        return likeEntities;
    }

    public void setLikeEntities(List<LikeEntity> likeEntities) {
        this.likeEntities = likeEntities;
    }

    public List<CommentEntity> getCommentsEntities() {
        return commentsEntities;
    }

    public void setCommentsEntities(List<CommentEntity> commentsEntities) {
        this.commentsEntities = commentsEntities;
    }
}
