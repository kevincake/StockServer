package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.UserEntity;

import java.util.List;

/**
 * Created by eavawu on 4/28/16.
 */
public interface IUserService {
    UserEntity saveUser(UserEntity userEntity);
    boolean updateUser(UserEntity userEntity);
    boolean deleteUser(long userId);
    boolean isPhoneRegister(String phone);
    UserEntity getUser(long userId);
    List getUserListByPage(int pageIndex);
    UserEntity findByPhoneAndPassword(String phone, String password);
}
