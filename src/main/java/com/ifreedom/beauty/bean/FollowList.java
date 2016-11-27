package com.ifreedom.beauty.bean;

import com.ifreedom.beauty.entity.UserEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/16/16
 * @todo:
 */
public class FollowList {
    private List<UserEntity> followUsers;

    public List<UserEntity> getFollowUsers() {
        return followUsers;
    }

    public void setFollowUsers(List<UserEntity> followUsers) {
        this.followUsers = followUsers;
    }
}
