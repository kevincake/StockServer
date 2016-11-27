package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.CommentEntity;
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
public class CommentRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public CommentEntity addComment(CommentEntity commentEntity) {
        CommentEntity merge = entityManager.merge(commentEntity);
        return merge;
    }

    @Transactional
    public List<CommentEntity> getComments(Long socialEntityId) {
        String sql = "SELECT * FROM comment WHERE socialId = :socialId";
        Query nativeQuery = entityManager.createNativeQuery(sql, CommentEntity.class);
        nativeQuery.setParameter("socialId",socialEntityId);
        List<CommentEntity> resultList = nativeQuery.getResultList();
        if (resultList.isEmpty()){
            return null;
        }else{
            return resultList;
        }

    }
}
