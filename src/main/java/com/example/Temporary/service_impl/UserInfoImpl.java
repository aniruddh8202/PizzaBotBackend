package com.example.Temporary.service_impl;


import com.example.Temporary.dao.TotalOrderDao;
import com.example.Temporary.dao.UserInfoDao;
import com.example.Temporary.dto.UserInfoDTO;
import com.example.Temporary.models.TotalOrder;
import com.example.Temporary.models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoImpl implements IUserInfo{

    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    TotalOrderDao totalOrderDao;

    @Override
    public UserInfo createUserInfo(UserInfoDTO userInfoDTO) {

        UserInfo userInfo = new UserInfo();

        TotalOrder totalOrder = totalOrderDao.getOne(userInfoDTO.getOrderId());

        userInfo.setTotalOrder(totalOrder);

        userInfo.setUserName(userInfoDTO.getUserName());

        userInfo.setUserPhone(userInfoDTO.getUserPhone());

        userInfo.setUserAddress(userInfoDTO.getUserAddress());

        userInfo.setPaymentMethod(userInfoDTO.getPaymentMethod());

        return userInfoDao.save(userInfo);
    }

    @Override
    public UserInfo updateUserInfo(Long id, UserInfoDTO userInfoDTO) {

        UserInfo userInfo = userInfoDao.getOne(id);

        TotalOrder totalOrder = totalOrderDao.getOne(userInfo.getUserInfoId());

        userInfo.setTotalOrder(totalOrder);

        userInfo.setUserName(userInfoDTO.getUserName());

        userInfo.setUserPhone(userInfoDTO.getUserPhone());

        userInfo.setUserAddress(userInfoDTO.getUserAddress());

        userInfo.setPaymentMethod(userInfoDTO.getPaymentMethod());


        return userInfoDao.save(userInfo);
    }

    @Override
    public String deleteUserInfo(Long id) {

        userInfoDao.deleteById(id);

        return "Successfully Deleted";
    }

    @Override
    public UserInfo getOne(Long id) {
        return userInfoDao.getOne(id);
    }

    @Override
    public List<UserInfo> getAll() {
        return userInfoDao.findAll();
    }
}
