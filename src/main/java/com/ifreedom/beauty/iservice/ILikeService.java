package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.LikeEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/14/16
 * @todo:
 */
public interface ILikeService {
    LikeEntity getLike(Long id);
    LikeEntity deleteLike(Long id);
    LikeEntity addLike(LikeEntity likeEntity);
    List<LikeEntity> getLikes(Long socialId);

    LikeEntity getLike(long socialId, Long userId);
}
