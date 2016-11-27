package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by eavawu on 4/28/16.
 */
@Component
public class UserRepository {
    @PersistenceContext
    EntityManager entityManager;
    public  UserEntity findUserByPhone(String phone){
        String sql = "select * from user where phone = :phone";
        Query nativeQuery = entityManager.createNativeQuery(sql, UserEntity.class);
        nativeQuery.setParameter("phone",phone);
        List<UserEntity> resultList = nativeQuery.getResultList();
        if (resultList.isEmpty()){
            return null;
        }else{
            return resultList.get(0);
        }
    };

    public UserEntity findByPhoneAndPassword(String phone, String password){
        String sql = "select * from user where phone = :phone and password = :password";
        Query nativeQuery = entityManager.createNativeQuery(sql, UserEntity.class);
        nativeQuery.setParameter("phone",phone);
        nativeQuery.setParameter("password",password);
        List<UserEntity> resultList = nativeQuery.getResultList();
        if (resultList.isEmpty()){
            return null;
        }else{
            return resultList.get(0);
        }
//        return singleResult;
    };

    public UserEntity getUser(Long userId) {
        return entityManager.find(UserEntity.class,userId);
    }

    @Transactional
    public UserEntity save(UserEntity userEntity){
        if (userEntity==null){
            return null;
        }
        return entityManager.merge(userEntity);
    }



}
