package com.ifreedom.beauty.service;

import com.ifreedom.beauty.constants.LogConstants;
import com.ifreedom.beauty.entity.UserEntity;
import com.ifreedom.beauty.repository.UserRepository;
import com.ifreedom.beauty.iservice.IUserService;
import com.ifreedom.beauty.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by eavawu on 4/28/16.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    public UserEntity saveUser(UserEntity userEntity) {
        if (userEntity == null) {
            LogUtil.error(LogConstants.DB, "saveOrUpdate user is null");
            return null;
        }
        if (userEntity.getName() == null) {
            LogUtil.error(LogConstants.DB, "saveOrUpdate user userName is null");
            return null;
        }
        UserEntity save = userRepository.save(userEntity);
        return save;
    }


    public boolean updateUser(UserEntity userEntity) {
        if (userEntity == null) {
            LogUtil.error(LogConstants.DB, "update user param is null");
            return false;
        }


        return false;
    }


    @Override
    public boolean deleteUser(long userId) {
        return false;
    }

    @Override
    public boolean isPhoneRegister(String phone) {
        UserEntity phoneEntity = userRepository.findUserByPhone(phone);
        if (phoneEntity == null) {
            return false;
        }
        return true;
    }

    @Override
    public UserEntity getUser(long userId) {
        return userRepository.getUser(userId);
    }


    @Override
    public List getUserListByPage(int pageIndex) {
        return null;
    }

    @Override
    public UserEntity findByPhoneAndPassword(String phone, String password) {
        return userRepository.findByPhoneAndPassword(phone, password);
    }

    public UserEntity findTop1ByPhoneAndPassword(String phone, String password) {
        return userRepository.findByPhoneAndPassword(phone, password);
    }



}
