package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.FollowEntity;
import com.ifreedom.beauty.entity.LikeEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/14/16
 * @todo:
 */
@Component
public class LikeRepository {
    @PersistenceContext
    EntityManager entityManager;
    public List<LikeEntity> getLikes(Long socialId) {
        String sql = "select * from likes where socialId = :socialId";
        Query nativeQuery = entityManager.createNativeQuery(sql, LikeEntity.class);
        nativeQuery.setParameter("socialId",socialId);
        return nativeQuery.getResultList();
    }
    @Transactional
    public LikeEntity addLike(LikeEntity likeEntity) {
        return entityManager.merge(likeEntity);
    }

    public LikeEntity getLike(long socialId, Long userId) {
        String sql = "select * from likes where socialId = :socialId and userId = :userId";
        Query nativeQuery = entityManager.createNativeQuery(sql, LikeEntity.class);
        nativeQuery.setParameter("socialId",socialId);
        nativeQuery.setParameter("userId",userId);
        List<LikeEntity> resultList = nativeQuery.getResultList();
        if (resultList.isEmpty()){
            return null;
        }else{
            return resultList.get(0);
        }
    }
    @Transactional
    public LikeEntity deleteLike(Long id) {
        LikeEntity likeEntity = entityManager.find(LikeEntity.class, id);
        if (likeEntity!=null){
            entityManager.remove(likeEntity);
        }
        return likeEntity;
    }
}
