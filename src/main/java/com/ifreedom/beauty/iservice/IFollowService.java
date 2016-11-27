package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.FollowEntity;
import com.ifreedom.beauty.entity.UserEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/6/16
 * @todo:
 */
public interface IFollowService {
     int isFollow(long  userId,long beFollowId);
     boolean addFollow(long userId,long beFollowId);
     boolean deleteFollow(long userId,long beFollowId);

     List<UserEntity> getFollowers(Long id);

     List<UserEntity> getBeFollowers(Long id);
}
