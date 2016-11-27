package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.LikeEntity;
import com.ifreedom.beauty.iservice.ILikeService;
import com.ifreedom.beauty.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/14/16
 * @todo:
 */
@Service
public class LikeService implements ILikeService {
    @Autowired
    LikeRepository likeRepository;
    @Override
    public LikeEntity getLike(Long id) {
        return null;
    }

    @Override
    public LikeEntity deleteLike(Long id) {
        return likeRepository.deleteLike(id);
    }

    @Override
    public LikeEntity addLike(LikeEntity likeEntity) {
        return likeRepository.addLike(likeEntity);
    }

    @Override
    public List<LikeEntity> getLikes(Long socialId) {
        return likeRepository.getLikes(socialId);
    }

    @Override
    public LikeEntity getLike(long socialId, Long userId) {
        return likeRepository.getLike(socialId,userId);
    }
}
