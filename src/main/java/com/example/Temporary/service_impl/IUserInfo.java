package com.example.Temporary.service_impl;

import com.example.Temporary.dto.UserInfoDTO;
import com.example.Temporary.models.UserInfo;

import java.util.List;

public interface IUserInfo {

    UserInfo createUserInfo(UserInfoDTO userInfoDTO);

    UserInfo updateUserInfo(Long id, UserInfoDTO userInfoDTO);

    String deleteUserInfo(Long id);

    UserInfo getOne(Long id);

    List<UserInfo> getAll();

}
